# Fork Join Pool

Project to test ForkJoin pool framework vs single thread vs Executor Service

## Project context

This is a simple kitchen implementation. 
A order is submit and produced by the kitchen.
Each order is a menu entry witch have a set of ingredients. Prepare each ingredient demands time, 
and gathering all together to form the desired menu order can also take stime.

That time is simulate using Thread.sleep.