/**
 * 停止线程的方法:
 * <li>threadObj.stop(): 此方法已过时,不推荐使用</li>
 * <li>
 *     在run方法中结合 isInterrupt() 和 return/break/抛出异常等方式停止线程<br/>
 *     interrupt(): 给线程一个终端标记
 * </li>
 *
 */
package org.qrl.juc.thread.basic.stop;