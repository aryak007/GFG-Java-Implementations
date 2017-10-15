/*
The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. 

Input:
First line contains number of test cases T. Each test case contain the integer value 'N' denoting days followed by an array of stock prices in N days.
Output:
The maximum profit is displayed as shown below. And if there is no profit then print "No Profit".


Constraints:
1 <=T<= 100
2 <=N<= 100
1 <=arr[i]<= 10000


Example

Input:
2
7
100 180 260 310 40 535 695
10
23 13 25 29 33 19 34 45 65 67
*/
import java.io.*;
import java.util.*;

class GFG{
    class Stock{
        int buy_day;
        int sell_day;
    }
    public static void main(String args[]) throws IOException{
        GFG g = new GFG();
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            g.maximiseProfit(arr,n);
            
        }
    }

    public void maximiseProfit(int arr[],int n){
        ArrayList<Stock> buySellStocks = new ArrayList<Stock>();
        int count = 0;
        int i = 0;
       while(i<=n-1){
            while(i<n-1 && arr[i]>=arr[i+1])
                i++;

            if(i==n-1)
                break;

            Stock stock = new Stock();
            stock.buy_day = i++;

            while(i<n-1 && arr[i]<arr[i+1]){
                i++;
            }
            stock.sell_day = i++;
            buySellStocks.add(stock);
            count++;
        }
        if(count==0)
            System.out.println("No Profit");
        else{
                for(i = 0;i<buySellStocks.size();i++){
                System.out.print("("+buySellStocks.get(i).buy_day+" "+buySellStocks.get(i).sell_day+") ");
            } 
        }
       
        System.out.println();
            
         
        return;
    }

}
