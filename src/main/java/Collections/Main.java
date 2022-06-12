package Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("mama");
        stringList.add("ded");
        stringList.add("test");
        stringList.add("papa");
        stringList.add("lala");

        List<Character> result = findText(stringList);
        System.out.println(result);
    }

    public static List<Character> findText(List<String> massiveString) {

        Iterator<String> stringIterator = massiveString.listIterator(); //делаем итерации по элементам

        Set<Character> result = new HashSet<>(); //сразу же создаю коллекцию Сет, для того чтобы сюда приходили фильтрованные слова + он удалял лишние буквы
        char[] word; //это будет слово в виде массива char
        int countWords = 0; //счетчик для первых 2 слов которые подходят условию

        while (stringIterator.hasNext()) {
            String temp = stringIterator.next(); //присвоил значение во временную переменную

            if (temp.length() % 2 != 0) continue; //фильтрую слова так как не может быть не четное число длины

            word = temp.toCharArray(); //тут из временной переменной делаю массив char этих букв

            if(isNiceWord(word) && countWords < 2){ //тут есть метод который фильтрует слова + сравнивается кол-во найденных слов
                countWords++;
                for (char c: word){
                    result.add(c); //добавляем в результат буквы нашего слова которое подходит под фильтрацию
                    //и Set урезает еще повторяющиеся буквы.
                }
            }

        }
        return new ArrayList<>(result); //возвращаем список
    }

    public static boolean isNiceWord(char[] word) { //принимаем массив букв определенного слова
        for (int i = 0; i < word.length; i++) { //этот внешний цикл отвечает за то чтобы сравнивать отдельно каждую БУКВУ
            int countMatches = 0; // кол-во повторений определенной буквы i
            for (int k = 0; k < word.length; k++) { //здесь мы сравниваем нашу букву i с каждой буквой слова (k)
                if(i == k) continue; //если позиция == наших букв , то пропускаем дальше сравнение, так как нам не нужно чтобы буква сравнивала сама себя

                if(word[i] == word[k]){ //здесь уже сравниваются значения
                    countMatches++;//счетчик буквы i
                }
            }
            if(countMatches % 2 == 0) return false; //если хоть одна буква будет четной по кол-ву в слове
            //выдаем false
            //почему четная, потому что убрал сравнение буквы самой себя if(i == k) continue;
        }
        return true; //если все не четные, это слово подходит.
    }
}
