import java.util.*;

public class LuckNumber {
    static final int GENERATE_MAX_NUMBER_BORDER=60;
    static final int GENERATE_MAX_AMOUNTOF_NUMBER=1000000;
    public static void main(String[] args) {
        Map<Integer,Integer>map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        fillToMapNumbers(map);
        mapTransferToList(map,list);
        findTenLuckyNumbers(set,list);
        System.out.println(list.size());
        System.out.println(map.size());
        System.out.println(set.size());

       /*
       ListIterator<Integer>listIterator= list.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        */
        Iterator<Integer>iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }

    private static void findTenLuckyNumbers(Set<Integer> set, List<Integer> list) {
        Collections.shuffle(list);
        while (set.size()<10){
            int random=(int) (Math.random()*GENERATE_MAX_AMOUNTOF_NUMBER);
            set.add(list.get(random));
        }
    }

    private static void mapTransferToList(Map<Integer, Integer> map, List<Integer> list) {
        for (Map.Entry<Integer,Integer>temp:map.entrySet()){
            int key=temp.getKey();
            int value=temp.getValue();
            for (int i=0;i<value;i++){
                list.add(key);
            }
        }

    }

    private static void fillToMapNumbers(Map<Integer, Integer> map) {
        for (int i=0;i<GENERATE_MAX_AMOUNTOF_NUMBER;i++){
            int randomNumber=createRandomNumber();
            if (map.containsKey(randomNumber)){
                int value=map.get(randomNumber);
                map.put(randomNumber,++value);
            }else {
                map.put(randomNumber,1);
            }
        }
    }

    private static int createRandomNumber() {
        return (int) (Math.random()*GENERATE_MAX_NUMBER_BORDER+1);
    }
}
