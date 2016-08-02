package com.flp.fms.view;
import java.util.Scanner;

import com.flp.fms.Exceptions.DuplicateRecordException;
import com.flp.fms.Exceptions.FieldEmptyException;

import com.flp.fms.Exceptions.NegativeFieldException;
import com.flp.fms.Exceptions.RecordNotFoundException;

import java.text.ParseException;

public class BootClass {

	private static Scanner sc=new Scanner(System.in);
	static UserInteraction userinteraction=new UserInteraction();

	public static void main(String[] args) throws ParseException, FieldEmptyException, NegativeFieldException, RecordNotFoundException, DuplicateRecordException {
		showMenu();
	}
	private static void showMenu()  throws ParseException,  FieldEmptyException, NegativeFieldException, RecordNotFoundException, DuplicateRecordException {
		int choice,i;
		while(true)
		{
			System.out.println("1.add film");
			System.out.println("2.modify film");
			System.out.println("3.remove film");
			System.out.println("4.search film");
			System.out.println("5.getAllfilm");
			System.out.println("6.add actor");
			System.out.println("7.modify actor");
			System.out.println("8.remove actor");
			System.out.println("9.search actor");
			System.out.println("10.getAllActor");
			System.out.println("11.exit");
			
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:userinteraction.addFilm();
					break;
			case 2:userinteraction.modifyFilm();
				   break;
			case 3:userinteraction.removeFilm();
				   break;
			case 4:userinteraction.searchFilm();
					break;
			case 5:userinteraction.getAllFilms();
					break;
			case 6:userinteraction.addActor();
					break;
			case 7:userinteraction.modifyActor();
					break;
			case 8:userinteraction.removeActor();
					break;
			case 9:userinteraction.searchActor();
			        break;
			case 10:userinteraction.getAllActors();
			        break;
			case 11:System.exit(0);
			   
			default:System.out.println("recheck your program");
			
			}
			
		}
		
	}
}
