class cqueue{
    int size=5;
    int arr[]=new int[size];
    int front,rear;

    cqueue(){
        front=-1;
        rear=-1;
    }
    public boolean Is_full(){
        if(front==0 && rear==size-1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean Is_empty(){
        if(front==-1){
            return true;
        }
        else{
            return false;
        }
    }
    public void enqueue(int item){
        if(Is_full()){
            System.out.println("queue is full");
        }
        else{
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=item;
            System.out.println("Inserted " + item);

        }
    }
    public int dequeue(){
        int el;
        if(Is_empty()){
            System.out.println("queue is full");
            return (-1);
        }
        else{
            el=arr[front];
            if(front==rear)
            {
                front=-1;
                rear=-1;
            }
            else{
                front=(front+1)%size;
            }
            return el;
        }
    }
    public void display(){
        int i;
        if(Is_empty()){
            System.out.println("Empty Queue");
        }
        else{
            System.out.println("Front -> " + front);
            System.out.println("Items -> ");
            for ( i = front; i != rear; i = (i + 1) % size){
              System.out.print(arr[i] + " ");
            }
            System.out.println(arr[i]);
            System.out.println("Rear -> " + rear);
        }
    }
    public static void main(String[] args) {
        cqueue q = new cqueue();

    // Fails because front = -1
    q.dequeue(); 

    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);

    // Fails to enqueue because front == 0 && rear == SIZE - 1
    q.enqueue(6);

    q.display();

    int elem = q.dequeue();

    if (elem != -1) {
      System.out.println("Deleted Element is " + elem);
    }
    q.display();

    q.enqueue(7);

    q.display();

    // Fails to enqueue because front == rear + 1
    q.enqueue(8);
    }

}