package utils;

import java.util.UUID;

public class UploadUtils {

	//解决文件名冲突
	public static String getUuidFileName (String fileName) {
		int idx = fileName.lastIndexOf("."); //aa.txt
		String extions = fileName.substring(idx); //txt
		return UUID.randomUUID().toString().replace("-", "")+extions;
	}
	
	public static void main(String[] args) {
		System.out.println(getUuidFileName("afsafas.txt"));
	}
	
	//实现目录分离，二级目录
	public static String getPath(String uuidFileName) {
		int code1 = uuidFileName.hashCode();
		int d1 = code1 & 0xf;  //作为一级目录
		int code2 = code1 >>> 4; 
		int d2 = code2 & 0xf ; //作为二级目录
		return d1+"\\"+d2+"\\";
	}
}
