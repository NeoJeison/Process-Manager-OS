package com.operational.processManager.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.operational.processManager.model.ActualProcess;

@Service
public class ProcessManagerService {
	
	public static final String LIST = "ps aux";
	public static final String KILL_BASE = "kill -9 ";
	public static final String SEP = "\\s+";
	
	public List<ActualProcess> getAllProcesses() {
		
		//Initialize list that will later be the output.
		List<ActualProcess> allProcesses = new ArrayList<ActualProcess>();
		//Gets environment in order to be able to execute commands.
		Runtime console = Runtime.getRuntime();
		
		try {
			
			//Executes list processes command.
			Process process = console.exec(LIST);
			//Waits for the process to be over.
			process.waitFor();
			//Buffer for the output of the command that i will read after.
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			//Discard header.
			br.readLine();
			//Starts processes reading.
			String line = br.readLine();
			
			while(line != null && !line.isEmpty()) {
				//Get every argument.
				String[] processArguments = line.split(SEP);
				//Command may have been fragmented by this split so i fixed it
				String command = "";
				for(int i = 10; i < processArguments.length; i++) {
					command += processArguments[i] + " ";
				}
				
				//Add process to the list.
				allProcesses.add(new ActualProcess(processArguments[0], processArguments[1], processArguments[2], processArguments[3], processArguments[4], 
						processArguments[5], processArguments[6], processArguments[7], processArguments[8], processArguments[9], command));
				
				//Read the next process.
				line = br.readLine();
				
			}
			
			//Running processes hold resources so now that is done, it's better to destroy it.
			process.destroy();
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		return allProcesses;
	}
	
	public void killAProcess(String pid) {
		//Gets environment in order to be able to execute commands.
		Runtime console = Runtime.getRuntime();
		
		try {
			//Executes kill process command.
			Process process = console.exec(KILL_BASE + pid);
			//Waits for the process to be over.
			process.waitFor();
			//Running processes hold resources so now that is done, it's better to destroy it.
			process.destroy();
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
