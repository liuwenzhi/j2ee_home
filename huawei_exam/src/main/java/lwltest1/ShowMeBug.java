package lwltest1;

public class ShowMeBug {
    public static void main(String[] arges) throws Exception{
        IA ia = (IA) createObject(IA.class.getName()+"$getHelloName=Abc");
        System.out.println(ia.getHelloName()); //方法名匹配的时候，输出“Abc”
        ia = (IA) createObject(IA.class.getName()+"$getTest=Bcd");
        System.out.println(ia.getHelloName()); //方法名不匹配的时候，输出null
    }

    //请实现方法createObject，接口中"getName()"方法名仅仅是个示例，不能写死判断
    public static Object createObject(String str) throws Exception {
        //throw new Exception("还没有实现的方法");
        String[] temp = str.split("\\$");
        //Class c = Class.forName(temp[0]);
        String[] cache = temp[1].split("=");
        IA ia = null;
        if("getHelloName".equals(cache[0])){
            ia = new IAImpl(cache[1]);
        }else{
            ia = new IAImpl();
        }
        return ia;
    }

    public static class IAImpl implements IA{

        private String name;

        public IAImpl(){

        }
        public IAImpl(String name){
            this.name = name;
        }
        public String getHelloName(){
            return name;
        }
    }
}
