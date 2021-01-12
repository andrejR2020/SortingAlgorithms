
/**
 * @author Andrejs Romanovskis
 * @version 12.01.2021
 */
public class MergeSort
{
    public static void main (String[] args){
        MergeSort merge = new MergeSort();
        int[] list = new int[args.length];
        for(int x = 0; x<args.length;x++){
           list[x] = Integer.parseInt(args[x]);
        }
        merge.split(list,0,list.length-1);
        for(int x = 0; x<list.length; x++){
            System.out.print(list[x] + " ");
        }
    }
    
    public void split(int[] list, int lowNum, int highNum){
        if(highNum <=lowNum){
            return;
        }
        
        int mid = (lowNum+highNum)/2;
        
        split(list, lowNum, mid);
        split(list, mid+1, highNum);
        mergeList(list, lowNum, mid, highNum);
        
    }
    
    public void mergeList(int[] list, int lowNum, int mid, int highNum){
        int leftSide[] = new int[mid-lowNum +1];
        int rightSide[] = new int[highNum - mid];
        
        for (int i = 0; i < leftSide.length; i++)
            leftSide[i] =list[lowNum + i];
        for (int i = 0; i < rightSide.length; i++)
            rightSide[i] = list[mid + i + 1];
         int l = 0;
         int r = 0;
        for (int i = lowNum; i < highNum + 1; i++) { 
            if (l < leftSide.length && r < rightSide.length) {
                if (leftSide[l] < rightSide[r]) {
                    list[i] = leftSide[l];
                    l++;
                } else {
                    list[i] = rightSide[r];
                    r++;
                }
            }   
            else if (l < leftSide.length) {
                list[i] = leftSide[l];
                l++;
            } else if (r < rightSide.length) {
                list[i] = rightSide[r];
                r++;
            }

        }
    }
}
