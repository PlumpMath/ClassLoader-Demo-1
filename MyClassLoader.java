import java.util.*;
import java.util.jar.*;
import java.io.*;
import java.lang.reflect.*;

public class MyClassLoader extends ClassLoader {
		private String directory;
			private Hashtable classes = new Hashtable();

				public MyClassLoader(String dir) {
							super(MyClassLoader.class.getClassLoader());
									this.directory = dir;
										}

					public synchronized Class loadClass(String name) throws ClassNotFoundException{
								return findClass(name);
									}

						public Class findClass(String className) {
									byte classByte[];
											Class result = null;

													result = (Class) classes.get(className);
															if (result != null) {
																			return result;
																					}
															        
																	try {
																					System.out.println("Find System Class");
																								if (!"Service".equals(className)) //我们需要将 ServiceInterface 由该 ClassLoader 的父类来加载，这一句很重要哦
																												return findSystemClass(className);
																										} catch (Exception e) {
																													}
																			try {
																							String file = "";
																										if ("".equals(this.directory))
																															file =  className + ".class";
																													else
																																		file = this.directory + File.separatorChar + className + ".class";

																																classByte = loadClassData(file);

																																			result = defineClass(className, classByte, 0, classByte.length);
																																						resolveClass(result);
																																									classes.put(className, result);
																																												return result;
																																														} catch(Exception e) {
																																																		System.out.println("Load Class Error in MyClassLoader" + e.getMessage());
																																																					return null;
																																																							}
																				}

							private byte[] loadClassData(String name) throws IOException {
										InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
												System.out.println(stream);
														int size = stream.available();
																byte buff[] = new byte[size ];
																		DataInputStream in = new DataInputStream(stream);
																				in.readFully(buff);
																						in.close();
																								return buff;
																									}
}
