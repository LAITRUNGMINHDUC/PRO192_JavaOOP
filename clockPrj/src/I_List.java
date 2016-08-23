/* Interface for a group of objects
 */

/**
 *
 * @author USER
 */
public interface I_List {
  // tim ma cua 1 phan tu trong nhom
  int find(String code);
  // them 1 phan tu, co nhap lieu
  void add(); 
  // xoa 1 phan tu, co nhap lieu
  void remove();
  // update 1 phan tu co nhap lieu
  void update();
  // sap xep ds
  void sort();
  // xuat ds
  void output();
}
