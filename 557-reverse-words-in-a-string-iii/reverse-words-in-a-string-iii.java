class Solution {
    public String reverseWords(String s) {
        String []str = s.trim().split("\s+");
        String rev="";
        for(int i=0;i<str.length-1;i++)
        {
            rev+=revString(str[i])+" ";
        }
        rev=rev+revString(str[str.length-1]);
        return rev;
    }
    public String revString(String s)
    {
        String str=new StringBuilder(s).reverse().toString();
        return str;
    }
}