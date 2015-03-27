/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.IOException;

/**
 * @author u11161
 */
public class pacDesign {
    
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Image mapa;
    private Image Bichos;
    private Image Mapaaaa;
    private Image pontos;
    private Image ponto;
    private Image pontozinho;
    private Sprite orange;
    public int orangeseq001Delay = 200;
    public int[] orangeseq001 = {0, 0, 0, 0, 0};
    private Image pink;
    private Sprite rosa;
    public int rosaseq001Delay = 200;
    public int[] rosaseq001 = {0, 0, 0, 0, 0};
    private Image verd;
    private Sprite azul;
    public int azulseq001Delay = 200;
    public int[] azulseq001 = {0, 0, 0, 0, 0};
    private Image MapaTeste;
    private Image orng;
    private Sprite PontinhoX;
    public int PontinhoXseq001Delay = 200;
    public int[] PontinhoXseq001 = {0};
    private Image pacteste;
    private Sprite pctest;
    public int pctestseq001Delay = 200;
    public int[] pctestseq001 = {0};
    private Image Pontao;
    private Sprite foge;
    public int fogeseq001Delay = 200;
    public int[] fogeseq001 = {0, 0, 0, 0, 0};
    private Image Pontinho;
    private Image DEAD;
    private Sprite pontaoo;
    public int pontaooseq001Delay = 200;
    public int[] pontaooseq001 = {0, 0, 0, 0, 0};
    private Image pontaooo;
    private Sprite pctest1;
    public int pctest1seq001Delay = 200;
    public int[] pctest1seq001 = {0};
    private Sprite red;
    public int redseq001Delay = 200;
    public int[] redseq001 = {0, 0, 0, 0, 0};
    private Image verm;
    private Image pacManzinho;
    private TiledLayer finalMapa;
    private Image FINALmapa;
    public int fMapaseq001Delay = 200;
    public int[] fMapaseq001 = {0};
//</editor-fold>//GEN-END:|fields|0|
    
//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|
/*
    public Image getMapa() throws java.io.IOException {//GEN-BEGIN:|1-getter|0|1-preInit
        if (mapa == null) {//GEN-END:|1-getter|0|1-preInit
            // write pre-init user code here
            mapa = Image.createImage("/mapa.png");//GEN-BEGIN:|1-getter|1|1-postInit
        }//GEN-END:|1-getter|1|1-postInit
        // write post-init user code here


        return this.mapa;//GEN-BEGIN:|1-getter|2|
    }//GEN-END:|1-getter|2|



    public Image getBichos() throws java.io.IOException {//GEN-BEGIN:|3-getter|0|3-preInit
        if (Bichos == null) {//GEN-END:|3-getter|0|3-preInit
            // write pre-init user code here
            Bichos = Image.createImage("/Bichos.png");//GEN-BEGIN:|3-getter|1|3-postInit
        }//GEN-END:|3-getter|1|3-postInit
        // write post-init user code here
        return this.Bichos;//GEN-BEGIN:|3-getter|2|
    }//GEN-END:|3-getter|2|























    public Image getPontao() throws java.io.IOException {//GEN-BEGIN:|81-getter|0|81-preInit
        if (Pontao == null) {//GEN-END:|81-getter|0|81-preInit
            // write pre-init user code here
            
            Pontao = Image.createImage("/Pontao.png");//GEN-BEGIN:|81-getter|1|81-postInit
        }//GEN-END:|81-getter|1|81-postInit
        
        return this.Pontao;//GEN-BEGIN:|81-getter|2|
    }//GEN-END:|81-getter|2|



    public Image getPontinho() throws java.io.IOException {//GEN-BEGIN:|83-getter|0|83-preInit
        if (Pontinho == null) {//GEN-END:|83-getter|0|83-preInit
            // write pre-init user code here
            Pontinho = Image.createImage("/Pontinho.png");//GEN-BEGIN:|83-getter|1|83-postInit
        }//GEN-END:|83-getter|1|83-postInit
        // write post-init user code here
        return this.Pontinho;//GEN-BEGIN:|83-getter|2|
    }//GEN-END:|83-getter|2|





    public Image getMapaaaa() throws java.io.IOException {//GEN-BEGIN:|133-getter|0|133-preInit
        if (Mapaaaa == null) {//GEN-END:|133-getter|0|133-preInit
            // write pre-init user code here
            Mapaaaa = Image.createImage("/Mapaaaa.png");//GEN-BEGIN:|133-getter|1|133-postInit
        }//GEN-END:|133-getter|1|133-postInit
        // write post-init user code here
        return this.Mapaaaa;//GEN-BEGIN:|133-getter|2|
    }//GEN-END:|133-getter|2|











    public Image getMapaTeste() throws java.io.IOException {//GEN-BEGIN:|316-getter|0|316-preInit
        if (MapaTeste == null) {//GEN-END:|316-getter|0|316-preInit
            // write pre-init user code here
            MapaTeste = Image.createImage("/MapaTeste.png");//GEN-BEGIN:|316-getter|1|316-postInit
        }//GEN-END:|316-getter|1|316-postInit
        // write post-init user code here
        return this.MapaTeste;//GEN-BEGIN:|316-getter|2|
    }//GEN-END:|316-getter|2|


*/
    public Image getPacteste() throws java.io.IOException {//GEN-BEGIN:|326-getter|0|326-preInit
        if (pacteste == null) {//GEN-END:|326-getter|0|326-preInit
            // write pre-init user code here
            pacteste = Image.createImage("/pacteste.png");//GEN-BEGIN:|326-getter|1|326-postInit
        }//GEN-END:|326-getter|1|326-postInit
        // write post-init user code here
        return this.pacteste;//GEN-BEGIN:|326-getter|2|
    }//GEN-END:|326-getter|2|

    public Sprite getPctest() throws java.io.IOException {//GEN-BEGIN:|327-getter|0|327-preInit
        if (pctest == null) {//GEN-END:|327-getter|0|327-preInit
            // write pre-init user code here
            pctest = new Sprite(getPacteste(), 10, 10);//GEN-BEGIN:|327-getter|1|327-postInit
            pctest.setFrameSequence(pctestseq001);//GEN-END:|327-getter|1|327-postInit
            // write post-init user code here
        }//GEN-BEGIN:|327-getter|2|
        return pctest;
    }//GEN-END:|327-getter|2|
/*
    public Image getPacManzinho() throws java.io.IOException {//GEN-BEGIN:|329-getter|0|329-preInit
        if (pacManzinho == null) {//GEN-END:|329-getter|0|329-preInit
            // write pre-init user code here
            pacManzinho = Image.createImage("/pacManzinho.png");//GEN-BEGIN:|329-getter|1|329-postInit
        }//GEN-END:|329-getter|1|329-postInit
        // write post-init user code here
        return this.pacManzinho;//GEN-BEGIN:|329-getter|2|
    }//GEN-END:|329-getter|2|

*/



    public Image getFINALmapa() throws java.io.IOException {//GEN-BEGIN:|372-getter|0|372-preInit
        if (FINALmapa == null) {//GEN-END:|372-getter|0|372-preInit
            // write pre-init user code here
            FINALmapa = Image.createImage("/FINALmapa.png");//GEN-BEGIN:|372-getter|1|372-postInit
        }//GEN-END:|372-getter|1|372-postInit
        // write post-init user code here

        return this.FINALmapa;//GEN-BEGIN:|372-getter|2|
    }//GEN-END:|372-getter|2|

    public TiledLayer getFinalMapa() throws java.io.IOException {//GEN-BEGIN:|373-getter|0|373-preInit
        if (finalMapa == null) {//GEN-END:|373-getter|0|373-preInit
            // write pre-init user code here
            finalMapa = new TiledLayer(10, 10, getFINALmapa(), 24, 32);//GEN-BEGIN:|373-getter|1|373-midInit
            int[][] tiles = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
            };//GEN-END:|373-getter|1|373-midInit
            // write mid-init user code here
            for (int row = 0; row < 10; row++) {//GEN-BEGIN:|373-getter|2|373-postInit
                for (int col = 0; col < 10; col++) {
                    finalMapa.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|373-getter|2|373-postInit
        // write post-init user code here
        return finalMapa;//GEN-BEGIN:|373-getter|3|
    }//GEN-END:|373-getter|3|

    public void updateLayerManagerForMapScene(LayerManager lm) throws java.io.IOException {//GEN-LINE:|381-updateLayerManager|0|381-preUpdate
        // write pre-update user code here
        getPontinhoX().setPosition(-504, -1332);//GEN-BEGIN:|381-updateLayerManager|1|381-postUpdate
        getPontinhoX().setVisible(true);
        lm.append(getPontinhoX());
        getFinalMapa().setPosition(6, -1329);
        getFinalMapa().setVisible(true);
        lm.append(getFinalMapa());//GEN-END:|381-updateLayerManager|1|381-postUpdate
        // write post-update user code here
    }//GEN-LINE:|381-updateLayerManager|2|
/*
    public Image getPontozinho() throws java.io.IOException {//GEN-BEGIN:|385-getter|0|385-preInit
        if (pontozinho == null) {//GEN-END:|385-getter|0|385-preInit
            // write pre-init user code here
            pontozinho = Image.createImage("/pontozinho.png");//GEN-BEGIN:|385-getter|1|385-postInit
        }//GEN-END:|385-getter|1|385-postInit
        // write post-init user code here
        return this.pontozinho;//GEN-BEGIN:|385-getter|2|
    }//GEN-END:|385-getter|2|

    public Image getPonto() throws java.io.IOException {//GEN-BEGIN:|387-getter|0|387-preInit
        if (ponto == null) {//GEN-END:|387-getter|0|387-preInit
            // write pre-init user code here
            ponto = Image.createImage("/ponto.png");//GEN-BEGIN:|387-getter|1|387-postInit
        }//GEN-END:|387-getter|1|387-postInit
        // write post-init user code here
        return this.ponto;//GEN-BEGIN:|387-getter|2|
    }//GEN-END:|387-getter|2|
*/
    public Image getPontos() throws java.io.IOException {//GEN-BEGIN:|399-getter|0|399-preInit
        if (pontos == null) {//GEN-END:|399-getter|0|399-preInit
            // write pre-init user code here
            pontos = Image.createImage("/pontos.png");//GEN-BEGIN:|399-getter|1|399-postInit
        }//GEN-END:|399-getter|1|399-postInit
        // write post-init user code here
        return this.pontos;//GEN-BEGIN:|399-getter|2|
    }//GEN-END:|399-getter|2|

    public Sprite getPontinhoX() throws java.io.IOException {//GEN-BEGIN:|422-getter|0|422-preInit
        if (PontinhoX == null) {//GEN-END:|422-getter|0|422-preInit
            // write pre-init user code here
            PontinhoX = new Sprite(getPontos(), 3, 3);//GEN-BEGIN:|422-getter|1|422-postInit
            PontinhoX.setFrameSequence(PontinhoXseq001);//GEN-END:|422-getter|1|422-postInit
            // write post-init user code here
        }//GEN-BEGIN:|422-getter|2|
        return PontinhoX;
    }//GEN-END:|422-getter|2|

    public Image getOrng() throws java.io.IOException {//GEN-BEGIN:|439-getter|0|439-preInit
        if (orng == null) {//GEN-END:|439-getter|0|439-preInit
            // write pre-init user code here
            orng = Image.createImage("/orng.png");//GEN-BEGIN:|439-getter|1|439-postInit
        }//GEN-END:|439-getter|1|439-postInit
        // write post-init user code here
        return this.orng;//GEN-BEGIN:|439-getter|2|
    }//GEN-END:|439-getter|2|

    public Sprite getOrange() throws java.io.IOException {//GEN-BEGIN:|440-getter|0|440-preInit
        if (orange == null) {//GEN-END:|440-getter|0|440-preInit
            // write pre-init user code here
            orange = new Sprite(getOrng(), 10, 10);//GEN-BEGIN:|440-getter|1|440-postInit
            orange.setFrameSequence(orangeseq001);//GEN-END:|440-getter|1|440-postInit
            // write post-init user code here
        }//GEN-BEGIN:|440-getter|2|
        return orange;
    }//GEN-END:|440-getter|2|

    public Image getPink() throws java.io.IOException {//GEN-BEGIN:|442-getter|0|442-preInit
        if (pink == null) {//GEN-END:|442-getter|0|442-preInit
            // write pre-init user code here
            pink = Image.createImage("/pink.png");//GEN-BEGIN:|442-getter|1|442-postInit
        }//GEN-END:|442-getter|1|442-postInit
        // write post-init user code here
        return this.pink;//GEN-BEGIN:|442-getter|2|
    }//GEN-END:|442-getter|2|

    public Sprite getRosa() throws java.io.IOException {//GEN-BEGIN:|443-getter|0|443-preInit
        if (rosa == null) {//GEN-END:|443-getter|0|443-preInit
            // write pre-init user code here
            rosa = new Sprite(getPink(), 10, 10);//GEN-BEGIN:|443-getter|1|443-postInit
            rosa.setFrameSequence(rosaseq001);//GEN-END:|443-getter|1|443-postInit
            // write post-init user code here
        }//GEN-BEGIN:|443-getter|2|
        return rosa;
    }//GEN-END:|443-getter|2|

    public Image getVerd() throws java.io.IOException {//GEN-BEGIN:|445-getter|0|445-preInit
        if (verd == null) {//GEN-END:|445-getter|0|445-preInit
            // write pre-init user code here
            verd = Image.createImage("/verd.png");//GEN-BEGIN:|445-getter|1|445-postInit
        }//GEN-END:|445-getter|1|445-postInit
        // write post-init user code here
        return this.verd;//GEN-BEGIN:|445-getter|2|
    }//GEN-END:|445-getter|2|

    public Sprite getAzul() throws java.io.IOException {//GEN-BEGIN:|446-getter|0|446-preInit
        if (azul == null) {//GEN-END:|446-getter|0|446-preInit
            // write pre-init user code here
            azul = new Sprite(getVerd(), 10, 10);//GEN-BEGIN:|446-getter|1|446-postInit
            azul.setFrameSequence(azulseq001);//GEN-END:|446-getter|1|446-postInit
            // write post-init user code here
        }//GEN-BEGIN:|446-getter|2|
        return azul;
    }//GEN-END:|446-getter|2|

    public Image getVerm() throws java.io.IOException {//GEN-BEGIN:|448-getter|0|448-preInit
        if (verm == null) {//GEN-END:|448-getter|0|448-preInit
            // write pre-init user code here
            verm = Image.createImage("/verm.png");//GEN-BEGIN:|448-getter|1|448-postInit
        }//GEN-END:|448-getter|1|448-postInit
        // write post-init user code here
        return this.verm;//GEN-BEGIN:|448-getter|2|
    }//GEN-END:|448-getter|2|

    public Sprite getRed() throws java.io.IOException {//GEN-BEGIN:|449-getter|0|449-preInit
        if (red == null) {//GEN-END:|449-getter|0|449-preInit
            // write pre-init user code here
            red = new Sprite(getVerm(), 10, 10);//GEN-BEGIN:|449-getter|1|449-postInit
            red.setFrameSequence(redseq001);//GEN-END:|449-getter|1|449-postInit
            // write post-init user code here
        }//GEN-BEGIN:|449-getter|2|
        return red;
    }//GEN-END:|449-getter|2|

    public Sprite getPctest1() throws java.io.IOException {//GEN-BEGIN:|451-getter|0|451-preInit
        if (pctest1 == null) {//GEN-END:|451-getter|0|451-preInit
            // write pre-init user code here
            pctest1 = new Sprite(getPacteste(), 10, 9);//GEN-BEGIN:|451-getter|1|451-postInit
            pctest1.setFrameSequence(pctest1seq001);//GEN-END:|451-getter|1|451-postInit
            // write post-init user code here
        }//GEN-BEGIN:|451-getter|2|
        return pctest1;
    }//GEN-END:|451-getter|2|

    public Image getPontaooo() throws java.io.IOException {//GEN-BEGIN:|453-getter|0|453-preInit
        if (pontaooo == null) {//GEN-END:|453-getter|0|453-preInit
            // write pre-init user code here
            pontaooo = Image.createImage("/pontaooo.png");//GEN-BEGIN:|453-getter|1|453-postInit
        }//GEN-END:|453-getter|1|453-postInit
        // write post-init user code here
        return this.pontaooo;//GEN-BEGIN:|453-getter|2|
    }//GEN-END:|453-getter|2|

    public Sprite getPontaoo() throws java.io.IOException {//GEN-BEGIN:|454-getter|0|454-preInit
        if (pontaoo == null) {//GEN-END:|454-getter|0|454-preInit
            // write pre-init user code here
            pontaoo = new Sprite(getPontaooo(), 10, 10);//GEN-BEGIN:|454-getter|1|454-postInit
            pontaoo.setFrameSequence(pontaooseq001);//GEN-END:|454-getter|1|454-postInit
            // write post-init user code here
        }//GEN-BEGIN:|454-getter|2|
        return pontaoo;
    }//GEN-END:|454-getter|2|

    public Image getDEAD() throws java.io.IOException {//GEN-BEGIN:|456-getter|0|456-preInit
        if (DEAD == null) {//GEN-END:|456-getter|0|456-preInit
            // write pre-init user code here
            DEAD = Image.createImage("/DEAD.png");//GEN-BEGIN:|456-getter|1|456-postInit
        }//GEN-END:|456-getter|1|456-postInit
        // write post-init user code here
        return this.DEAD;//GEN-BEGIN:|456-getter|2|
    }//GEN-END:|456-getter|2|

    public Sprite getFoge() throws java.io.IOException {//GEN-BEGIN:|457-getter|0|457-preInit
        if (foge == null) {//GEN-END:|457-getter|0|457-preInit
            // write pre-init user code here
            foge = new Sprite(getDEAD(), 10, 10);//GEN-BEGIN:|457-getter|1|457-postInit
            foge.setFrameSequence(fogeseq001);//GEN-END:|457-getter|1|457-postInit
            // write post-init user code here
        }//GEN-BEGIN:|457-getter|2|
        return foge;
    }//GEN-END:|457-getter|2|




    
}
