import java.io.*;
import java.util.*;

public class LinearRegression{
	private ArrayList<Double> x;
	private ArrayList<Double> y;
	private double lineSlope;
	private double yInter;

	public LinearRegression(){
		x = new ArrayList<Double>();
		y = new ArrayList<Double>();
	}

	public void addData(String fileName, String splitKey){
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String temp;
			for (int i = 0; (temp = br.readLine())!= null; i++) {
				String[] tempArr = temp.split(splitKey);
				x.add(Double.parseDouble(tempArr[0]));
				y.add(Double.parseDouble(tempArr[1]));
			}
		}catch(IOException e){
		}
	}

	public void regression(){
		lineSlope = crossDevi() / xDevi();
		yInter = sumY() - (lineSlope * sumX());
		System.out.println("Your line is: y = " + lineSlope + "x + " + yInter);
	}

	public double crossDevi(){
		double averageX = sumX() / x.size();
		double averageY = sumY() / y.size();
		double sum = 0;
		for(int i = 0; i < x.size(); i++){
			sum+=(x.get(i)-averageX) * (y.get(i)-averageY);
		}
		return sum;
	}

	public double xDevi(){
		double averageX = sumX() / x.size();
		double sum = 0;
		for(int i = 0; i < x.size(); i++){
			sum+=(x.get(i)-averageX) * (x.get(i)-averageX);
		}
		return sum;
	}

	public double sumX(){
		double sum = 0;
		for(Double currentX : x)
			sum += currentX.doubleValue();
		return sum;
	}

	public double sumY(){
		double sum = 0;
		for(Double currentY : x)
			sum += currentY.doubleValue();
		return sum;
	}

	public static void main(String[] args) {
		LinearRegression lr = new LinearRegression();
		lr.addData("plot.txt", " ");
		lr.regression();
	}
}