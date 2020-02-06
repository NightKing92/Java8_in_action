#Java8学习感想
##chapter1 Java8简单概述，一些新特性了解
* 核心新特性：Lambda（匿名函数）、流、默认方法
1. java8对硬件的影响：流式处理逻辑上无共享数据的集合可以充分利用
现代cpu多核的特性，这种并行处理数据的能力可以极大提升代码执行的效
率。
2. Stream API的引入：它类似一种“花哨”的迭代器，它提供的方法可以
链接起来形成一个复杂的流水线，用来高效并行处理逻辑上无关联的功能。
3. 引入将行为参数化把代码传递给方法的概念，说的通俗点就是：把你的
代码作为参数传递给另一个方法的能力。
4. lambda表达式的一个粗浅的理解：将java8以前匿名类的写法改的更为
简捷，是方法更像是作为函数的“参数”。
5. Stream API解决了集合处理时的套路和晦涩，以及难以利用多核。以往
的代码习惯在处理集合的过程中，单线程，串行处理，在需求要大量遍历集合
以筛选数据时，会造成代码大量的冗余，重复，不利于阅读和维护，同时容易
出错；多核性能浪费，效率低下。
6. 默认方法这块看的有点晕以后再说。
##chapter2 通过行为参数化传递代码
* 这一步分可以查看chapter2包中代码，其中以根据对苹果不同特性的筛选
需求对代码一步步的优化，从集合遍历写道lambda表达式。
* 行为参数化，就是一个方法接收多个不同的行为作为参数，并在内部使用
它们，完成不同行为的能力。
* 行为参数化可让代码更好地适应不断变化的要求，减轻未来的工作量。
* 传递代码，就是就新行为作为参数传递给方法。但在java8之前实现起来很
啰嗦。为接口中声明许多只用一次的实体类而造成的啰嗦代码，在java8之前
可以用匿名类来减少。
* java API包含很多可以用不同行为进行参数化的方法，包括排序、线程和GUI处理。