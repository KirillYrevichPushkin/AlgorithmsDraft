package Simple;


//selection sort
public class ChoiceSort {

    public static void main(String[] args) {

        int [] inputArray = new int[15];
        int [] outputArray;

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = (int) (Math.random()*100);
            System.out.println(inputArray[i]);
        }

        System.out.println("+++++++");

        outputArray = selectionSorted2(inputArray);
        for (int i = 0; i < outputArray.length; i++) {
            System.out.println(outputArray[i]);
        }

    }

//В сортировке методом выбора вы последовательно перебираете всех игроков и выбираете (отсюда и название) самого низкорослого из них. Этот игрок меняется
//местами с тем, который стоит в крайней левой позиции (0). Левый игрок отсортирован, и в дальнейшем уже перемещаться не будет. Обратите внимание: в этом
//алгоритме отсортированные игроки собираются слева (нижние индексы), тогда
//как при пузырьковой сортировке они собираются справа.
//Следующий проход начинается с позиции 1, а обнаруженный минимальный
//элемент меняется местами с элементом в позиции 1. Процесс продолжается до тех
//пор, пока не будут отсортированы все игроки
//количество перестановок O(N)
//количество сравнений O(N2)
    static int[] selectionSorted(int[] arr){
        int [] arrTemp = arr;

        int temp = 0;
        int tempValue = 0;

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length ; j++) {
                if(min > arr[j]){
                    temp = j;
                    min = arr[j];
                }
            }
            tempValue=arr[i];
            arr[i] = min;
            arr[temp] = tempValue;
        }
        return arr;
    }

// вариант получше
    static int[] selectionSorted2(int[] arr){
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp = i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[temp]>arr[j]){
                    temp = j;
                }
            }
            swap(i, temp, arr);
        }
        return arr;
    }



    public static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


}
