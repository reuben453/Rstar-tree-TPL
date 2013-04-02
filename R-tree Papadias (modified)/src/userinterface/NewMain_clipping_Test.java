/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.awt.*;


public class NewMain_clipping_Test extends Canvas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	TreeCreation tc = new TreeCreation("ab.rtr",2, 2,256,128);
    	RTDirNode temp1= null;
    	RTDataNode temp2=null;
    	
    	
    	if(tc.rt.root_is_data==false)
    		temp1= (RTDirNode) tc.rt.root_ptr;
    	else
    	{
    		temp2= (RTDataNode) tc.rt.root_ptr;
    		//System.out.println("Data");
    	}
    	    	
    	
    	TPL_algorithm a = new TPL_algorithm();
    	RTDataNode cur_node = temp2;
    	Data d = new Data();
    	d.data[0]=d.data[1]=d.data[2]=d.data[3]=200;
    	
    	//d.data[0]=d.data[1]=d.data[2]=d.data[3]=200;
    	cur_node.data[0]=d;
    	Data d1 = new Data();
    	d1.data[0]=d1.data[1]=400;
    	d1.data[2]=d1.data[3]=300;
    	cur_node.data[1]=d1;
    	
    	Data d2 = new Data();
    	d2.data[0] = d2.data[1] = 350;
    	d2.data[2] = d2.data[3] = 250;
    	cur_node.data[2] = d2;
    	//cur_node.data[0].
    	//cur_node.data[0].
    	//float mid[]=new float[2];
    	PPoint q = new PPoint();
    	q.data[0]=400;q.data[1]=100;
    	
    	   	
    	//mid[0]=500;
    	//mid[1]=500;
    	float cur[]= new float[4];
    	cur=cur_node.get_mbr();
    	cur_node.res_mbr = new float[4];
    	for(int i=0;i<4;i++)
    		cur_node.res_mbr[i]=cur[i];
    	
    	for(int i=0;i<4;i++)
    		System.out.println(cur_node.res_mbr[i]);
    	
    	RTDataNode one = new RTDataNode(tc.rt, cur_node, 1);
    	RTDataNode two = new RTDataNode(tc.rt, cur_node, 2);
        Data d3 = new Data();
        d3.data[0] = d3.data[1] = 500;
        d3.data[2] = d3.data[3] = 100;
        cur_node.data[3] = d3;
        RTDataNode three = new RTDataNode(tc.rt, cur_node, 3);
        cur_node.data[3] = null;
        three.data[0] = d3;
    	a.cand_set.add(one);
    	//a.cand_set.add(two);
        a.cand_set.add(three);
    	//boolean call=a.compute_res_mbr((float)Float.POSITIVE_INFINITY, cur_node, mid, q);
    	float Bp[] = a.clipping(q, cur_node);
        //float trim=a.trim(q, a.cand_set, cur_node);
        
        
        
        
        //if(call == false)
        //	System.out.println("MBR not changed");
        //else
        //	System.out.println("MBR changed");
    	System.out.println("\n");
        for(int i=0;i<4;i++)
    		System.out.println(cur_node.res_mbr[i]);
        tc.display();
    }
   
   
}
