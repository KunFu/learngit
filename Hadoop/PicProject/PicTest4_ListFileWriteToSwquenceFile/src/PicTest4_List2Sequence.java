// cc SmallFilesToSequenceFileConverter A MapReduce program for packaging a collection of small files as a single SequenceFile
//import java.io.IOException;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.BytesWritable;
//import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.*;


public class PicTest4_List2Sequence {  
   
   
	 //本地linux磁盘输出路径  
	 static String PATH = "/home/hadoop/Desktop/out";  
	 static SequenceFile.Writer writer = null;  
	   
	 public static void main(String[] args) throws Exception{  
	  
	//设置读取本地磁盘文件  
	  Configuration conf = new Configuration();  
	  conf.set("fs.default.name", "file:///");  
	  conf.set("mapred.job.tracker", "local");  
	  
	   
	  
	//linux磁盘下路径  
	 //String path = "/home/greatmap/World/";  
	  String path = "/home/hadoop/Desktop/data/uav/TestPicture/"; 
	  
	  URI uri = new URI(path);  
	  FileSystem fileSystem = FileSystem.get(uri, conf);  
	  //实例化writer对象  
	  writer = SequenceFile.createWriter(fileSystem, conf, new Path(PATH), Text.class, BytesWritable.class);  
	    
	  //递归遍历文件夹，并将文件下的文件写入sequenceFile文件  
	  listFileAndWriteToSequenceFile(fileSystem,path);  
	    
	  //关闭流  
	  org.apache.hadoop.io.IOUtils.closeStream(writer);  
	  
	}  
	  
	   
	  
	/**** 
	  * 递归文件;并将文件写成SequenceFile文件 
	  * @param fileSystem 
	  * @param path 
	  * @throws Exception 
	  */  
	 public static void listFileAndWriteToSequenceFile(FileSystem fileSystem,String path) throws Exception{  
	  final FileStatus[] listStatuses = fileSystem.listStatus(new Path(path));  
		  for (FileStatus fileStatus : listStatuses) {  
			   if(fileStatus.isFile()){  
			    Text fileText = new Text(fileStatus.getPath().toString());  
			    System.out.println(fileText.toString());  
			    //返回一个SequenceFile.Writer实例 需要数据流和path对象 将数据写入了path对象  
			    FSDataInputStream in = fileSystem.open(new Path(fileText.toString()));  
			    byte[] buffer = IOUtils.toByteArray(in);  
			    in.read(buffer);  
			    BytesWritable value = new BytesWritable(buffer);  
			      
			    //写成SequenceFile文件  
			    writer.append(fileText, value);  
			      
			   }  
			   if(fileStatus.isDirectory()){  
			    listFileAndWriteToSequenceFile(fileSystem,fileStatus.getPath().toString());  
			   }  
		//   org.apache.hadoop.io.IOUtils.closeStream(writer);  
	     
	     }  
	  }
 }