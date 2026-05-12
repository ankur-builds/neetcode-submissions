class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return "";
        }
        StringBuilder encoded = new StringBuilder();
        for (String str : strs){
            encoded.append(str.length());
            encoded.append("#");
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        if(str==null || str.isEmpty()){
            return list;
        }

        int n = str.length();
        for(int i = 0; i<n; ++i){
            int j = i+1;
            while(j<n && str.charAt(j)!='#'){
                j++;
            }

            int length = Integer.valueOf(str.substring(i,j));
            if(j+length<n){
                list.add(str.substring(j+1,j+1+length));
                i = j+length;
            } else 
                continue;
        }

        return list;
    }
}
