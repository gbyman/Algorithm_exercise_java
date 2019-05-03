package algorithm_sort;
// ��
public class Heap {

	int[] a;// ���� ������ �ϴ� �迭
	int n;// ���� ����ִ� ����� ����
	
//	���� �����Ѵ�
//	
//	@param size ���� ����� �� �ִ� ����� �ִ� ����
	public Heap(int size) {
		// �迭 a���� a[1] ~ a[size+1]�� ����Ѵ�
		// a[0]�� ������� �����Ƿ� size+1���� ��Ҹ� Ȯ���� �ʿ䰡 �ִ�
		a = new int[size+1];
		n = 0;
	}
	
//	���� x��° ��Ҹ� �ʿ��� ��ұ��� ����ø���
//	
//	@param x ����ø� ����� ÷��
	private void upHeap(int x) {
		//����ø� ����� ���� value�� �־�д�
		int value = a[x];
		
		//��Ұ� ��Ʈ���� �ö���� �ʾ�����
		//'�θ� �ڽĺ��� ũ��'��� ������ ������ ������ �ݺ��Ѵ�
		while(x > 1 && a[x/2] > value) {
			
			//�θ� ���� �ڽ����� �ű��
			a[x] = a[x/2];
			
			//ó���� ��带 �θ�� �Ѵ�
			x /= 2;
		}
		
		//���������� �Ű����� �� ��Ұ� ��������
		a[x] = value;
	} 
	
//	���� ��Ҹ� ����Ѵ�
//	
//	@param elem ����� ���
	public void insert(int elem) {
		
		//���� ����� �� �ִ� ������ �ִ��� Ȯ���Ѵ�
		if(n >= a.length) {
			System.err.println("�� �̻� ���� ��Ҹ� ����� �� ����.");
			System.exit(1);
		}
		
		//��Ҹ� �ϴ� ���� �������� �ִ´�
		a[++n] = elem;
		
		//�߰��� ��Ҹ� ����ø���
		upHeap(n);
	}
	
//	���� ó�� ��� a[1]�� �ʿ��� ������ ���� ������
	private void downHeap() {
		
		//�������� ����� ���� value�� ������ �д�
		int value = a[1];
		
		//��Ʈ���� �����Ͽ� ��� i�� �ڽ��� ������ �ִ� �� �ݺ��Ѵ�
		int i = 1;
		while(i < n/2) {
			
			//��� i�� �ڽ� �� ���� ���� ��� j�� �Ѵ�
			int j = i * 2;
			if(j + 1 <= n && a[j] > a[j + 1]) {
				j++;
			}
			
			//���� �θ� �ڽĺ��� ũ�� �ʴٴ� ���谡 �����ϸ�,
			//�� �̻� �������� �ʿ䰡 ����
			if(value <= a[j]) {
				break;
			}
			
			//��� i�� ��� j�� ���� �ְ�, ������ ��� j�� ó���ϵ��� �Ѵ�
			a[i] = a[j];
			i = j;
		}
		
		//���� ó�� ����� ���� ��� i�� �ִ´�
		a[i] = value;
	}
	
//	������ ���� ���� ��Ҹ� �����Ѵ�
//	����� ���� ��ȯ
//	
//	@return ������ ����� ��
	int deleteMin() {
		
		//���� ����ִ��� Ȯ���Ѵ�
		if(n < 1) {
			System.err.println("���� ����ִ�");
			System.exit(1);
		}
		
		//��Ʈ ��Ҹ� ���� ������ �Ѵ�
		//(���� ó�� ��Ұ� ��Ʈ�� �ش�)
		int value = a[1];
		
		//���� ������ ��Ҹ� ���� ó������ �̵��Ѵ�
		a[1] = a[n--];
		
		//������ �̵��� ��Ҹ� ������ ��ġ���� ����������
		downHeap();
		
		return value;
	}
}