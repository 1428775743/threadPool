# threadPool
这是一个我学习完线程池原理做的一个简单的线程池

# Task
任务执行接口，实现这个接口
才能放入ThreaPool的任务队列

#创建ThreadPool 和 使用
new ThreadPool(size) 可以在初始化的时候设置需要的消费线程数量
MyQueue tasks = threadPool.getQueue()获取到任务队列,然后进行添加任务(此处将任务队列暴露出来了，不是很好)
执行thradPoolk.start()方法即可运行线程池





