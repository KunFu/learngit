PicTest3
作者：khun

每个split读取一整个文件（WholeFileInputformat）
输入的Key是文件名，Value是文件内容。
输出到SequenceFile中，输出的Key是文件名，Value是文件内容。

遍历目录，conf.set("mapreduce.input.fileinputformat.input.dir.recursive", "true");



/×


1.hadoop权威指南中的WholeFileInputFormat：分片时按文件分，存入hbase：
rowkey：任务ID(32位)+photoname(10+10位)，不同簇保存图片内容等：
_____________________________________________________________________________________________
| rowkey  | time |                列簇（ColumnFamily）                                       |
|_________|______|__________________________________________________________________________|
|         |      | 照片内容p_content | 图片大小:p_size  | 图片类型:p_type  | 图片时间:p_time  |
|_________|______|___________________|_________________|__________________|_________________|
|         |      |                   |                 |                  |                 |
| rowkey  |  t   |     content       |       size      |       type       |p_time:creattime |
|         |      |                   |                 |                  |p_time:updatetime|
|_________|______|___________________|_________________|__________________|_________________|

×/

