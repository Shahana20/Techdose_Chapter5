class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s.length() <2) {
            return false;
        }
        if(s=="()"||s=="{}"||s=="[]")
        {
            return true;
        }

        for(char ch : s.toCharArray()){
            switch(ch){
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if(stack.isEmpty()||stack.pop()!='(')
                        return false;
                    break;
                case '}':
                    if(stack.isEmpty()||stack.pop()!='{')
                        return false;
                    break;
                case ']':
                    if(stack.isEmpty()||stack.pop()!='[')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();

    }}