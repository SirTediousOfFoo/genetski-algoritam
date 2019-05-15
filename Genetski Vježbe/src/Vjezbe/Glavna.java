package Vjezbe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
//jedinka koja je najbolja ne�e mutirati ni nestati ali mo�e u�i u kri�anje.
//kri�anje stvara dvoje djece od odabranih roditelja, ako se ne kri�aju roditelji se prepisuju dalje
public class Glavna {

	public static void main(String[] args) {
		Integer velicinaPopulacije = null, brojIteracija;
		Double vjerojatnostKrizanja, vjerojatnostMutacije;
		BufferedReader citac;
		//U�itavamo parametre algoritma iz vanjskog file-a
		try {
			citac = new BufferedReader(new FileReader(new File("parametri.txt")));
			velicinaPopulacije = Integer.parseInt(citac.readLine());
			vjerojatnostKrizanja = Double.parseDouble(citac.readLine());
			vjerojatnostMutacije = Double.parseDouble(citac.readLine());
			brojIteracija = Integer.parseInt(citac.readLine());
			 
			citac.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nema file-a");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Gre�ka s pisanjem");
			e.printStackTrace();
		}
		//stvorimo populaciju
		List<Integer> populacija = stvoriPopulaciju(velicinaPopulacije);
		
		//selekcija: na�i dobrotu cijele populacije, ra�unati dobrotu svake jedinke i baciti u sme�e one kod kojih je omjer 
		// dobrota pojedinca / dobrota populacije najmanji(10 komada)
		//onda nasumi�no kri�ati ovih 10 koje ostanu i kopirati njih i njihovu djecu u idu�u iteraciju populacije
	/*	for(int i = 0; i < velicinaPopulacije; i++)
		{
			Random izbor = new Random();
			int roditelj1 = 0;
			int roditelj2 = 0;
			do
			{
				roditelj1 = izbor.nextInt(velicinaPopulacije);
				roditelj2 = izbor.nextInt(velicinaPopulacije);
			}while(roditelj1 == roditelj2);
		}*/
		
	}


	public static ArrayList<Integer> selekcija(ArrayList<Integer> populacija)
	{
		ArrayList<Integer> novaPopulacija = new ArrayList<>();
		Map<Integer, Double> privremenaLista = new HashMap<>();
		Double dobrotaPopulacije = 0.0;
		//ra�unamo dobrotu svake jedinke, spremamo u mapu za kasnije sortiranje i odbabir top 10 jedinki
		for(int i = 0; i < populacija.size(); i++)
		{
			double dobrotaJedinke = dobrota(populacija.get(i));
			privremenaLista.put(i, dobrotaJedinke);
			dobrotaPopulacije += dobrotaJedinke;
		}
		dobrotaPopulacije = dobrotaPopulacije / populacija.size();
		return novaPopulacija;
	}
	public static ArrayList<Integer> stvoriPopulaciju(Integer velicinaPopulacije)
	{
		ArrayList<Integer> populacija = new ArrayList<>();
		Random jedinka = new Random();
		for(int i = 0; i < velicinaPopulacije; i++)
		{
			populacija.add(jedinka.nextInt(1024));//stvara random broj od 0-1023
		}
		return populacija;
	}
	
	public static double dobrota(int jedinka)
	{
		// Funkcija raèuna dobrotu jedinke (int jedinka) prema funkciji prikaznoj u tekstu zadatka
		// Dozvoljene ulazne vrijednosti su u otvorenom intervalu [0, 1023]
		// Funkcija vraæa -1 ako je zadana nedozvoljena vrijednost
		
		if (jedinka < 0 || jedinka >= 1024)
		{
			return -1;
		}

		if (jedinka >= 0 && jedinka < 30)
		{
			return 60.0;
		}
		else if (jedinka >= 30 && jedinka < 90)
		{
			return (double)jedinka + 30.0;
		}
		else if (jedinka >= 90 && jedinka < 120)
		{
			return 120.0;
		}
		else if (jedinka >= 120 && jedinka < 210)
		{
			return -0.83333 * (double)jedinka + 220;
		}
		else if (jedinka >= 210 && jedinka < 270)
		{
			return 1.75 * (double)jedinka - 322.5;
		}
		else if (jedinka >= 270 && jedinka < 300)
		{
			return 150.0;
		}
		else if (jedinka >= 300 && jedinka < 360)
		{
			return 2.0 * (double)jedinka - 450;
		}
		else if (jedinka >= 360 && jedinka < 510)
		{
			return -1.8 * (double)jedinka + 918;
		}
		else if (jedinka >= 510 && jedinka < 630)
		{
			return 1.5 * (double)jedinka - 765;
		}
		else if (jedinka >= 630 && jedinka < 720)
		{
			return -1.33333 * (double)jedinka + 1020;
		}
		else if (jedinka >= 720 && jedinka < 750)
		{
			return 60.0;
		}
		else if (jedinka >= 750 && jedinka < 870)
		{
			return 1.5 * (double)jedinka - 1065;
		}
		else if (jedinka >= 870 && jedinka < 960)
		{
			return -2.66667 * (double)jedinka + 2560;
		}
		else
		{
			return 0;
		}
	}        
}
