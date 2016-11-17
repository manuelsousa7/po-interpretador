import java.io.Serializable;

public class Coordenada implements Serializable{
	int _x;
	int _y;
	public Coordenada(int x,int y){
		_x = x;
		_y = y;
	}
	public int getX(){
		return _x;
	}
	public int getY(){
		return _y;
	}
}
