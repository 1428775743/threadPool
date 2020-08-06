# threadPool
这是一个我学习完线程池原理做的一个简单的线程池

创建ThreadPool
ThreadPool threadPool = new ThreadPool(size); 初始化传入消费线程数
MyQueue<Task> tasks = threadPool.getQueue(); 获取到消费队列
就可以在tasks添加实现Task接口的任务了
threadPool.start() 线程池就开始运行了

具体可以查看测试用例

# Task
任务执行接口，实现这个接口
才能放入ThreaPool的任务队列


当前版本 是简单的只能设置固定消费消除的线程池:
不能对任务和线程数量进行自动化的管理，
也不能设置任务的权重，也没有设置线程的争抢策略