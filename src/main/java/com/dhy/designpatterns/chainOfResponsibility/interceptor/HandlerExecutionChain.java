package com.dhy.designpatterns.chainOfResponsibility.interceptor;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project fighting-core
 * @Description 拦截器链
 * @Author lvaolin
 * @Date 2021/12/26 下午2:25
 */
@Data
public class HandlerExecutionChain {

	//目标 Controller
	private MyController handler;

	/**
	 * 拦截器集合
	 */
	private HandlerInterceptor[] interceptors;

	/**
	 * 拦截器集合 与 interceptors 相互转换
	 */
	private List<HandlerInterceptor> interceptorList;

	//用来记录preHandler成功的拦截器个数的，在triggerAfterCompletion 方法中将要用到
	//因为triggerAfterCompletion只会触发preHandler执行成功的拦截器
	private int interceptorIndex = -1;


	public HandlerExecutionChain() {
	}

	public HandlerExecutionChain(MyController handler,  HandlerInterceptor... interceptors) {
		this.handler = handler;
		this.interceptors = interceptors;
	}


	public MyController getHandler() {
		return this.handler;
	}

	public void addInterceptor(HandlerInterceptor interceptor) {
		initInterceptorList().add(interceptor);
	}

	public void addInterceptor(int index, HandlerInterceptor interceptor) {
		initInterceptorList().add(index, interceptor);
	}

	public void addInterceptors(HandlerInterceptor... interceptors) {
		if (!ObjectUtils.isEmpty(interceptors)) {
			CollectionUtils.mergeArrayIntoCollection(interceptors, initInterceptorList());
		}
	}

	private List<HandlerInterceptor> initInterceptorList() {
		if (this.interceptorList == null) {
			this.interceptorList = new ArrayList<>();
			if (this.interceptors != null) {
				// An interceptor array specified through the constructor
				CollectionUtils.mergeArrayIntoCollection(this.interceptors, this.interceptorList);
			}
		}
		this.interceptors = null;
		return this.interceptorList;
	}

	/**
	 * Return the array of interceptors to apply (in the given order).
	 * @return the array of HandlerInterceptors instances (may be {@code null})
	 */
	public HandlerInterceptor[] getInterceptors() {
		if (this.interceptors == null && this.interceptorList != null) {
			this.interceptors = this.interceptorList.toArray(new HandlerInterceptor[0]);
		}
		return this.interceptors;
	}


	/**
	 * 执行过滤器集合的preHandle方法
	 * Apply preHandle methods of registered interceptors.
	 * @return {@code true} if the execution chain should proceed with the
	 * next interceptor or the handler itself. Else, DispatcherServlet assumes
	 * that this interceptor has already dealt with the response itself.
	 */
	boolean applyPreHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HandlerInterceptor[] interceptors = getInterceptors();
		if (!ObjectUtils.isEmpty(interceptors)) {
			//正序执行
			for (int i = 0; i < interceptors.length; i++) {
				HandlerInterceptor interceptor = interceptors[i];
				if (!interceptor.preHandle(request, response, this.handler)) {
					triggerAfterCompletion(request, response, null);
					return false;
				}
				//记录preHandler成功的最大下标
				this.interceptorIndex = i;
			}
		}
		return true;
	}

	/**
	 * 执行过滤器集合的postHandle方法（倒序执行）
	 * Apply postHandle methods of registered interceptors.
	 */
	void applyPostHandle(HttpServletRequest request, HttpServletResponse response, ModelAndView mv)
			throws Exception {

		HandlerInterceptor[] interceptors = getInterceptors();
		if (!ObjectUtils.isEmpty(interceptors)) {
			//注意这个拦截器执行的先后顺序是和preHandle相反的，倒序执行
			for (int i = interceptors.length - 1; i >= 0; i--) {
				HandlerInterceptor interceptor = interceptors[i];
				interceptor.postHandle(request, response, this.handler, mv);
			}
		}
	}

	/**
	 * 执行过滤器集合的afterCompletion方法（倒序执行）
	 * Trigger afterCompletion callbacks on the mapped HandlerInterceptors.
	 * Will just invoke afterCompletion for all interceptors whose preHandle invocation
	 * has successfully completed and returned true.
	 */
	void triggerAfterCompletion(HttpServletRequest request, HttpServletResponse response,  Exception ex)
			throws Exception {

		HandlerInterceptor[] interceptors = getInterceptors();
		if (!ObjectUtils.isEmpty(interceptors)) {
			//注意这个拦截器执行的先后顺序是和preHandle相反的，并且只执行 preHandle成功的过滤器
			for (int i = this.interceptorIndex; i >= 0; i--) {
				HandlerInterceptor interceptor = interceptors[i];
				try {
					interceptor.afterCompletion(request, response, this.handler, ex);
				}
				catch (Throwable ex2) {
					ex2.printStackTrace();
				}
			}
		}
	}



}