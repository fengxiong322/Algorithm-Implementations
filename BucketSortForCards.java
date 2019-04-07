import java.io.*;
import java.util.*;

public class BucketSortForCards{
	String[] cards;
	public BucketSortForCards(){
		//Gets input for cards
		try{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		cards = br.readLine().split(" ");
		}catch(IOException e){}
	}

	public ArrayList<String> sort(){//This is the sorting algorithm
		ArrayList<String>[] buckets = new ArrayList[13];//Creates 13 buckets, to hold card numbers, from A-K

		for(int i = 0; i < buckets.length; i++)//For each Bucket
			buckets[i] = new ArrayList<String>();//Inititialize the ArrayList

		for(int i = 0; i < cards.length; i++){//For each card
			buckets[Integer.parseInt(cards[i].substring(0, cards[i].length()-1))].add(cards[i]);//Put them in their according bucket.
		}
		buckets[0] = insertionSort(buckets[0]);//Sort the first bucket
		for(int i = 1; i < buckets.length; i++){//For each bucket
			buckets[i] = insertionSort(buckets[i]);//Sort the bucket
			buckets[0].addAll(buckets[i]);//Add the bucket to the first bucket
		}
		return buckets[0];//Return the first bucket
	}

	public ArrayList<String> insertionSort(ArrayList<String> input){//The insertion sort to sort individual buckets
		for(int i = 1; i < input.size(); i++){//for the size of the bucket
			String temp = input.remove(i);//Remove the String at the current index
			int j = 0;
			for(j = 0; j < i; j++)//Starting from 0, loop to right before the removed index.
				if(temp.charAt(temp.length()-1) < input.get(j).charAt(input.get(j).length()-1))//if the current character is bigger
					break;//Leave the for loop
			input.add(j, temp);//At the place where the loop was exited, add the new piece
		}
		return input;//Return the sorted ArrayList
	}

	public static void main(String[] args) {
		System.out.println((new BucketSortForCards()).sort());
	}
}