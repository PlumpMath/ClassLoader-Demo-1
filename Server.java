import java.lang.reflect.*;

public class Server {
		private ServiceInterface service;
			public void updateService(String location) throws Exception {
						MyClassLoader cl = new MyClassLoader(location);
								Class c = cl.loadClass("Service");
										service = (ServiceInterface)c.newInstance();
											}

				public void processRequest() throws Exception {
							Class c = service.getClass();
									service.run();
										}
}
