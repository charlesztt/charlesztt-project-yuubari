package com.prinzkarl.yuubari.iotools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DictListReader {
	public static ArrayList<String> dictListReader(String fileName) throws IOException
	{
		ArrayList<String> targetList = new ArrayList<String>();
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		for(String line; (line = br.readLine()) != null;)
		{
			targetList.add(line);
		}
		br.close();
		fr.close();
		return targetList;
	}
}
