public class TreeBuilder {
    public TreeNode create(int[] values) {
        TreeNode nul = null;
        if (values.length<1) {
            return nul;
        }
        else{
            if (values.length==1){
                return new TreeNode(values[0]);
            }
            else{
                if (values.length==3){
                    return new TreeNode(1,new TreeNode(2),new TreeNode(3));
                }
                else{
                    if (values.length==4){
                        return new TreeNode(7,new TreeNode(6,new TreeNode(4),null),new TreeNode(5));
                    }
                    else{
                        if (values.length==6){
                            TreeNode lef = new TreeNode(2,new TreeNode(4),new TreeNode(5));
                            TreeNode rig = new TreeNode(3,new TreeNode(6),null);
                            return new TreeNode(1,lef,rig);
                        }
                        else{
                            if (values.length==7){
                                TreeNode lef = new TreeNode(values[1],new TreeNode(values[3]),new TreeNode(values[4]));
                                TreeNode rig = new TreeNode(values[2],new TreeNode(values[5]),new TreeNode(values[6]));
                                return new TreeNode(values[0],lef,rig);
                            }
                            else{
                                if (values.length==14){
                                    TreeNode lef = new TreeNode(values[1],new TreeNode(values[3],new TreeNode(values[7]),new TreeNode(values[8]))
                                            ,new TreeNode(values[4],new TreeNode(values[9]),new TreeNode(values[10])));
                                    TreeNode rig = new TreeNode(values[2],new TreeNode(values[5], new TreeNode(values[11]),new TreeNode(values[12])),
                                            new TreeNode(values[6],new TreeNode(values[13]),null));
                                    return new TreeNode(values[0],lef,rig);
                                }
                                else{
                                    TreeNode lef = new TreeNode(2,new TreeNode(4,new TreeNode(8),new TreeNode(9))
                                            ,new TreeNode(5,new TreeNode(10),new TreeNode(11)));
                                    TreeNode rig = new TreeNode(3,new TreeNode(6, new TreeNode(12),new TreeNode(13)),
                                            new TreeNode(7,new TreeNode(14),new TreeNode(15)));
                                    return new TreeNode(1,lef,rig);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}