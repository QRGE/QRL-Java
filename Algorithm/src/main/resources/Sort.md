# 排序算法的稳定性
如果两个相等的元素在排序前后的相对位置保持稳定, 那么这是稳定的排序算法
- 例如 5, 2, 3_a, 4, 7, 3_b
- 稳定的排序: 1, 3_a, 3_b, 2, 4, 6, 7
- 不稳定的排序: 1, 3_b, 3_a, 2, 4, 6, 7
- 对于自定义对象进行排序时, 稳定性会影响最终的排序效果

# 原地算法
原地算法: In-place Algorithm
- 不依赖额外的资源或依赖少数的额外资源, 仅依赖输出来覆盖输入
- 空间复杂度为 O(1) 的算法都可认为是原地算法