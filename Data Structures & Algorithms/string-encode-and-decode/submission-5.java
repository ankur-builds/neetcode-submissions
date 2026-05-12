class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        char[] ch = str.toCharArray();
        List<String> list = new ArrayList<>();
        for(int i =0; i<ch.length; ++i){
            StringBuilder s = new StringBuilder();
            while(ch[i]!='#'){
                s.append(ch[i]);
                ++i;
            }

            int n = Integer.valueOf(s.toString());
            list.add(str.substring(i+1, i+n+1));
            i = i+n;
        }

        return list;
    }
}
