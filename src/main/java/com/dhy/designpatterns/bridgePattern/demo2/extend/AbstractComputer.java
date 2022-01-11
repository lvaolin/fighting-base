package com.dhy.designpatterns.bridgePattern.demo2.extend;

import com.dhy.designpatterns.bridgePattern.demo1.cpu.ICpu;
import com.dhy.designpatterns.bridgePattern.demo1.disk.IDisk;
import com.dhy.designpatterns.bridgePattern.demo1.memory.IMemory;
import lombok.Data;

/**
 * @Project fighting-core
 * @Description 计算机
 * @Author lvaolin
 * @Date 2022/1/11 下午7:12
 */

@Data
public abstract class AbstractComputer {

    public abstract String showInfo();
}
