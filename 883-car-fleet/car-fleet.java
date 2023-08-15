class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        if(position.length == 1)    return 1;
        Stack<Double> myStack = new Stack<>();
        int[][] combine = new int[position.length][2];
        for(int i = 0; i < position.length; i++)
        {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }
        
        Arrays.sort(combine, (a,b) -> a[0] - b[0]);
        for(int i = position.length-1; i >= 0; i--)
        {
            double time = (double) (target - combine[i][0]) / combine[i][1];
            
            if(!myStack.isEmpty() && time <= myStack.peek())
                continue;
            else
                myStack.push(time);
        }
        return myStack.size();
    }
}