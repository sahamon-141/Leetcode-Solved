class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int min = Math.min(ver1.length,ver2.length);
        int result = 0;
        
        for(int i=0;i<min;i++){
            if(Integer.parseInt(ver1[i])>Integer.parseInt(ver2[i])){
                return 1;
            }
            if(Integer.parseInt(ver1[i])<Integer.parseInt(ver2[i])){
                return -1;
            }           
        }
        
        if(ver1.length>ver2.length){
            for(int i=min;i<ver1.length;i++){
                if(Integer.parseInt(ver1[i])>0){
                    return 1;
                }
            }
        }
        if(ver1.length<ver2.length){
            for(int i=min;i<ver2.length;i++){
                if(Integer.parseInt(ver2[i])>0){
                    return -1;
                }
            }
        }
        return 0;
    }
}