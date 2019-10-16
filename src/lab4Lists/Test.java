package lab4Lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		
		try {
			File foxandcat = new File("foxandcat.txt");
			Scanner sc = new Scanner(foxandcat);
			
			while (sc.hasNext())
			{
				String temp = sc.next();
				for(int i = 0; i < temp.length(); i++)
				{
					if(temp.substring(i, i+1).contentEquals("?")
							|| temp.substring(i, i+1).contentEquals("!")
							|| temp.substring(i, i+1).contentEquals(",")
							|| temp.substring(i, i+1).contentEquals(".")
							|| temp.substring(i, i+1).contentEquals(":")
							|| temp.substring(i, i+1).contentEquals(";"))
					{
						temp = temp.substring(0, i) + temp.substring(i+1, temp.length());
					}
				}
				list.add(temp);
			}
			
			//	remove all words starting with A or a
			for (int i = 0; i < list.getLength(); i++)
			{
				if (list.getEntry(i).substring(0, 1).contentEquals("a")
						|| list.getEntry(i).substring(0, 1).contentEquals("A"))
				{
					list.remove(i);
					i--;
				}
			}
			
			//	find the indices of "TO" and "BE"
			for (int i = 0; i < list.getLength(); i++)
			{
				if (list.getEntry(i).contentEquals("to")
						|| list.getEntry(i).contentEquals("be"))
				{
					System.out.print(" " + list.getEntry(i) + "" + i);
				}
			}
			
			//	replace "FOX" with "ELEPHANT"
			for (int i = 0; i < list.getLength(); i++)
			{
				if (list.getEntry(i).equals("Fox"))
				{
					list.replace(i, "Elephant");
				}
				else if (list.getEntry(i).equals("fox"))
				{
					list.replace(i, "elephant");
				}
			}
			
			//printwriter
			PrintWriter printer = new PrintWriter("elephantandcat.txt");
			for (int i = 0; i < list.getLength(); i++)
			{
				if (i % 15 == 14) {
					printer.println(list.getEntry(i) + " ");
				}
				else {
					printer.print(list.getEntry(i) + " ");
				}
			}
			printer.close();
			
			//	clear & make sure its empty
			list.clear();
			if(list.isEmpty())
			{
				System.out.println('\n' + "List is now empty.");
			}
			
		} catch(FileNotFoundException ex) {
			System.out.println ("foxandcat.txt not found");
		}

	}
}
