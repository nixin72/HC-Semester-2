package pDumaresq_B20_A03_MusicSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MusicSystem {
	public ArrayList<Song> songArray = new ArrayList<Song>();

	File file;
	Scanner readFile;
	Scanner writeFile;
	Song song;
	private String fileName;

	public void setFileName(String f) {
		fileName = f;
	}
	public String getFileName() {
		return fileName;
	}
	
	/*
	 * This method will read in all data from the music.txt text file and create
	 * an array of song objects out of the data read in. The file reader is
	 * created inside a try/catch block so if the file is never found, then you
	 * can return that to the user. It will also do validation to check if each
	 * of the objects contains 5 elements. Otherwise it will return an error. It
	 * will check if everything read that is supposed to be a String can
	 * properly be converted from String to int.
	 */
	public boolean readFromFile() {
		int numSongs = 0;
		setFileName("music.txt");
		try {
			
			file = new File(getFileName());
			readFile = new Scanner(file);
			readFile.useDelimiter("~|\r|\n");

			while (readFile.hasNext()) {
				song = new Song();

				try {
					song.setYear(Integer.parseInt(readFile.next()));
					song.setRank(Integer.parseInt(readFile.next()));
					song.setArtist(readFile.next());
					song.setTitle(readFile.next());
					song.setDownloads(readFile.nextInt());

					if (readFile.hasNextLine() == true) {
						readFile.nextLine();
					}
					songArray.add(song);
					numSongs++;
				} 
				catch (NumberFormatException e) {
					String error = "There is a number format error in the text file";
					errorInTextFile(error, numSongs);
				} 
				catch (ArrayIndexOutOfBoundsException e) {
					String error = "There too many items in the text file";
					errorInTextFile(error, numSongs);
				} 
				catch (InputMismatchException e) {
					String error = "There's not enough items in the text file";
					errorInTextFile(error, numSongs);
				} 
				catch (Exception e) {
					String error = "There was an unknown error in the text file";
					errorInTextFile(error, numSongs);
				}
			}
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}

	private void errorInTextFile(String error, int lineNum) {
		song.setYear(0);
		song.setRank(0);
		song.setTitle("");
		song.setDownloads(0);
		song.setArtist(error + " on line " + lineNum + ".");
		songArray.add(song);
	}

	/*
	 * This method will simply write to the sortedMusic.txt file. it will first
	 * call the bubblesort method and then print everything out. If the file
	 * couldn't be found, then file createFile() method is called.
	 */
	public boolean writeToFile() {
		try {
			file = new File("sortedMusic.txt");
			writeFile = new Scanner(file);
			FileWriter write = new FileWriter(file, false);
		

			for (int q = 0; q < songArray.size(); q++) {
				write.write(songArray.get(q).getYear() + "~");
				write.write(songArray.get(q).getRank() + "~");
				write.write(songArray.get(q).getArtist() + "~");
				write.write(songArray.get(q).getTitle() + "~");
				write.write(songArray.get(q).getDownloads() + "~\r\n");
				
			}

			write.close();
			return true;

		} catch (FileNotFoundException e) {
			if (!createFile())
				return false;
			else
				return true;
		} catch (IOException e) {
			return false;
		}
	}

	/*
	 * This method simply creates a sortedMusic.txt text file incase the
	 * writeToFile method couldn't find the proper file.
	 */
	public boolean createFile() {
		try {
			file = new File("sortedMusic.txt");
			file.createNewFile();
			writeToFile();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/*
	 * This method performs a bubble sort on the newSong array sorting each of
	 * the Song objects by year published.
	 */
	public void bubbleSortYear() {
		boolean sorted = false;
		int loopend = songArray.size();
		Song temp;

		while (!sorted && loopend > 1) {
			sorted = true;
			for (int q = 1; q < loopend; q++) {
				if (songArray.get(q - 1).getRank() > songArray.get(q).getRank()) {
					temp = songArray.get(q - 1);
					songArray.set(q - 1, songArray.get(q));
					songArray.set(q, temp);

					sorted = false;
				} // end if
				if (songArray.get(q - 1).getYear() > songArray.get(q).getYear()) {
					temp = songArray.get(q - 1);
					songArray.set(q - 1, songArray.get(q));
					songArray.set(q, temp);

					sorted = false;
				} // if
			} // for
			loopend--;
		} // while
	}// bubbleSortYear()

	/*
	 * This method doesn't do a whole lot. It will simply loop through each item
	 * in the newSong array until it finds an object in it who's title matches
	 * the parameter t. if the two match, then the method return true,
	 * indicating that the object was found. Otherwise, the method will return
	 * false and the object wasn't found. It will also set a public variable
	 * index to the index that the song object was found at so that that index
	 * can be accessed inside the MusicSystemFrame class.
	 */
	public int linearSearchTitle(String t) {
		int index = -1;
		int k = 0;
		while (index == -1 && k < songArray.size()) {
			if (songArray.get(k).getTitle().equalsIgnoreCase(t))
				index = k;
			k++;
		}
		return index;
	}

	/*
	 * This method does a binary search through all the songs searching first by
	 * year and then by rank. It will first call the method that will perform a
	 * bubble sort on the array. Then, once the objects in the array are sorted
	 * by year, it will split the array in two. If the item you're looking for
	 * is greater than the first half, it will look in the second half. To look
	 * at the second half it will again split it in two and check one of the
	 * halves of the array. It will continue to split the array into smaller and
	 * smaller pieces until it finds the Song object with the matching year. It
	 * will then perform the same operation on all objects of a certain rank and
	 * find them. It will then find an object that has the coresponding year and
	 * rank and return it's index so I can access the correct object in the
	 * MusicSystemFrame class.
	 */
	public int binarySearchYearRank(int y, int r) {
		bubbleSortYear();
		int bottom = 0;
		int top = songArray.size() - 1;
		int songIndex = -1;
		int middle = 0;
		while (bottom <= top && songIndex == -1) {
			middle = (top + bottom) / 2;

			if (songArray.get(middle).getYear() < y) {
				bottom = middle + 1;
			} else if (songArray.get(middle).getYear() > y) {
				top = middle - 1;
			} else if (songArray.get(middle).getYear() == y) {

				if (songArray.get(middle).getRank() < r) {
					bottom = middle + 1;
				} else if (songArray.get(middle).getRank() > r) {
					top = middle - 1;
				} else if (songArray.get(middle).getRank() == r) {
					songIndex = middle;
				}
			}
		}

		if (songIndex != -1)
			return songIndex;
		else
			return -1;
	}
}
