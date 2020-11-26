/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.getway;

/**
 *
 * @author Md Ashiqur Rahman
 */
import java.util.List;
public interface IQueryable<Model> {
    public List<Model> get();
    public Model get(int id);
    public Model save(Model model);
    public boolean delete(int id);
    public List<Model> search(String saerchText);
    public int size();
}
