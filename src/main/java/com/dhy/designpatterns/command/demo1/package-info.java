/**
 * @Title package-info
 * @Description
 *
 *
 * 命令模式
 *
 * 命令接口
 * 命令处理者接口
 *
 * 每个命令中包含一个或多个处理者
 *
 * 负责人Invoker 负责接收命令(setCommand(ICommand command))和执行命令(invoker())
 *
 *
 *1. 发送者（Sender）——亦称“触发者（Invoker）”——类负责对
 * 请求进行初始化，其中必须包含一个成员变量来存储对于命
 * 令对象的引用。发送者触发命令，而不向接收者直接发送请
 * 求。注意，发送者并不负责创建命令对象：它通常会通过构
 * 造函数从客户端处获得预先生成的命令。
 *
 *
 * 2. 命令（Command）接口通常仅声明一个执行命令的方法。
 *
 * 3. 具体命令（Concrete Commands） 会实现各种类型的请求。
 * 具体命令自身并不完成工作，而是会将调用委派给一个业务
 * 逻辑对象。但为了简化代码，这些类可以进行合并。
 * 接收对象执行方法所需的参数可以声明为具体命令的成员变
 * 量。你可以将命令对象设为不可变，仅允许通过构造函数对
 * 这些成员变量进行初始化。
 *
 * 4. 接收者（Receiver）类包含部分业务逻辑。几乎任何对象都
 * 可以作为接收者。绝大部分命令只处理如何将请求传递到接
 * 收者的细节，接收者自己会完成实际的工作。
 *
 * 5. 客户端（Client）会创建并配置具体命令对象。客户端必须
 * 将包括接收者实体在内的所有请求参数传递给命令的构造函
 * 数。此后，生成的命令就可以与一个或多个发送者相关联了。
 *
 *
 * @Author lvaolin
 * @Date 2022/1/26 21:50
 **/
package com.dhy.designpatterns.command.demo1;