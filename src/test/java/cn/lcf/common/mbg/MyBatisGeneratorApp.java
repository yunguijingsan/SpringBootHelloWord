package cn.lcf.common.mbg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MyBatisGeneratorApp {
	public static void main(String[] args) {
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			File configFile = new File("src/main/resources/mbg/generatorConfig-orcl.xml");
			System.out.println(configFile.getAbsolutePath());
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
					callback, warnings);
			myBatisGenerator.generate(new ProgressCallback() {
				
				@Override
				public void startTask(String taskName) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void saveStarted(int totalTasks) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void introspectionStarted(int totalTasks) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void generationStarted(int totalTasks) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void done() {
					System.out.println("done....");
				}
				
				@Override
				public void checkCancel() throws InterruptedException {
					// TODO Auto-generated method stub
					
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
