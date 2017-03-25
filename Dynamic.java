public class Dynamic {
		public static void main(String[] args) throws Exception {
					Server ser = new Server();
							ser.updateService(""); //首先会调用当前路径下 Service#run 方法
									ser.processRequest(); //当前路径下的 Service#run 输出Service----33---Run
											System.out.println("===================");
													ser.updateService("new");  //当前路径下有一个 new 文件夹，new 文件夹中有一个 Service.class 文件，这个文件的 run 函数会打印出 Service----22---Run
															ser.processRequest();//调用 ./new/Service.class#run 方法
																}
}
