import java.io.*;//We assume that the input will be from a seperate file in this example

public class InsertionSort{
  int[] integerArray;//The code used to sort integers can be applied to any other numerical data type(eg. long, float, double) as well as characters
  String[] stringArray;//Can be used to sort any other type of object that has the compareTo() function properly formatted
  
  public void getIntegerInput(){//Adapt this method for different types of input
    integerArray = new int[20];
    try{
      BufferedReader br = new BufferedReader(new FileReader("integers.txt"));
      String temp;
      for(int i = 0; (temp = br.readLine()) != null; i++){
        integerArray[i] = Integer.parseInt(temp);
      }
    }catch(IOException e){
      System.out.println(e);
    }
  }
  
  public void getStringInput(){//Adapt this method for different types of input
    stringArray = new int[20];
    try{
      BufferedReader br = new BufferedReader(new FileReader("strings.txt"));
      String temp;
      for(int i = 0; (temp = br.readLine()) != null; i++){
        stringArray[i] = temp;
      }
    }catch(IOException e){
      System.out.println(e);
    }
  }
  
	public void stringInsertionSort(){
		int smallest;
		for(int i = 0; i < stringArray.length; i++){
			int j;
			smallest = stringArray.length-1;
			for(j=i; j<stringArray.length-1; j++){
				if(stringArray[smallest].compareTo(students[j])<0){
					smallest = j;
				}
			}
			stringArray = cycle(stringArray, smallest);
		}
	}
  
  private String[] stringCycle(String[] stringArr, int end){//Rotates a section of the array, between 0 and end
		String temp = stringArr[end];
		for(int i = end-1; i >=0;i--){
			stringArr[i+1] = stringArr[i];
		}
		stringArr[0] = temp;
    return stringArr;
	}
  
	public void intInsertionSort(){
		int smallest;
		for(int i = 0; i < intArray.length; i++){
			int j;
			smallest = intArray.length-1;
			for(j=i; j<intArray.length-1; j++){
				if(intArray[smallest]<intArray[j]){
					smallest = j;
				}
			}
			intArray = cycle(intArray, smallest);
		}
	}
  
  private int[] intCycle(int[] intArr, int end){//Rotates a section of the array, between 0 and end
		int temp = intArr[end];
		for(int i = end-1; i >=0;i--){
			intArr[i+1] = intArr[i];
		}
		intArr[0] = temp;
    return intArr;
	}
  
  public void toString(){
    if(intArray != null)
      for(int i = 0; i < intArray.length-1; i++)
        System.out.println(intArray[i]);
    if(stringArray != null)
      for(int i = 0; i < stringArray.length-1; i++)
        System.out.println(stringArray[i]);
  }
  
  public static void main(String[] args){
    InsertionSort is = new InsertionSort();
    is.getStringInput();
    is.stringInsertionSort();
    is.getIntInput();
    is.intInsertionSort();
    System.out.println(is);
  }
}
