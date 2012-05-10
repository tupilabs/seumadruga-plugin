/**
 * Copyright (c) 2012 Bruno P. Kinoshita
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jenkins.plugins.seumadruga;

import java.util.Random;

/**
 * Provides Seu Madruga sentences.

 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
public class SentenceGenerator {

    private static final String[] SENTENCES = {
            "Eu sabia que voc&ecirc; era idiota, mas n&atilde;o a n&iacute;vel executivo!",
            "N&atilde;o h&aacute; nada mais trabalhoso do que viver sem trabalhar!", 
            "A vingan&ccedil;a nunca &eacute; plena, mata a alma e a envenena.",
            "N&atilde;o existe trabalho ruim. O ruim &eacute; ter que trabalhar.",
            "As pessoas boas devem amar seus inimigos.",
            "As d&iacute;vidas s&atilde;o sagradas!",
            "Estou falando com a mula, n&atilde;o com seus carrapatos!",
            "Devemos perdoar as ofensas&#x2026; Devemos perdoar as afrontas&#x2026; Devemos perdoar os alugu&eacute;is atrasados&#x2026;", 
            "Voc&ecirc;s n&atilde;o podem viver um &uacute;nico dia em paz?! Em paz:P,A,S, paz!",
            "Eu ca&iacute; cinco vezes. Mas ele caiu seis! E o juiz caiu oito! Bom&#x2026;&eacute; que as vezes a gente acertava ele&#x2026;",
            "O burro empaca perto do trigo…", 
            "Eu, mesmo sem um centavo no bolso, sempre trago no rosto um sorriso franco e espont&acirc;neo. &Oacute;, veja!", 
            "Quando a fome aperta, a vergonha afrouxa…", 
            "S&atilde;o todas assim: come&ccedil;am ficando com o chap&eacute;u e acabam ficando com a carteira!",
            "Isto &eacute; uma cali&uacute;nia! Uma cali&uacute;nia! Voc&ecirc; sabe o que &eacute; uma cali&uacute;nia?", 
            "Se eu soubesse que tinha mandado um burro fazer isso, ia eu mesmo!",
            "Como ousa me acordar &agrave;s 10 da madrugada, Chaves!?",
            "Como dizia meu velho av&ocirc;: &#x2018;Se quiser vir a ser alguma coisa, que devore os livros!&#x2019;",
            "Na hora do aperto se aprende&#x2026;",
            "Sou um cidad&atilde;o consciente, n&atilde;o fan&aacute;tico!",
            "Minha senhora, se acha que pode me comprar com alguns presentinhos, eu vou lhe dizer uma coisa&#x2026; Eu aceito!",
            "&Eacute; isso que eu digo: n&atilde;o h&aacute; nada como dever.",
            "Estou juntando para te dar tudo de uma vez, um mont&atilde;o no fim do ano.", 
            "N&atilde;o h&aacute; luta pior do que aquela que n&atilde;o se enfrenta.",
            "Isso &eacute; a primeira coisa que se deve ensinar na escola: A prenuncia&ccedil;&atilde;o.",
            "Atores vemos, costumes n&atilde;o sabemos&#x2026;",
            "Voc&ecirc; sabe quanto custa trazer um artista do estrangeiro? Ainda mais sendo de outro pa&iacute;s? Eu tive que arcar com as burocracias! Portanto, me sinto na penosa obriga&ccedil;&atilde;o de pedir uma ajuda. O que puderem! Qualquer coisa!",
            "Este veio do norte da &Aacute;frica do Sul, e o outro do sul da Am&eacute;rica do Norte.",
            "Acontece que o Quico est&aacute; perguntando quem foi Crist&oacute;v&atilde;o Colombo e Crist&oacute;v&atilde;o Colombo foi quem descobriu o M&eacute;xico. Tem que se estudar, Chaves, para n&atilde;o ser burro.",
            "Esta caveira representa &#x2018;prerigo&#x2019;,'PRE- RI- GO&#x2019;.",
            "O qu&ecirc;? Na escola nunca te ensinaram bot&acirc;nica? Bogot&aacute; &eacute; um pa&iacute;s!",
            "Isto aqui &eacute; gesso, gesso, J-E-S-O, &#x201c;gesso&#x201d;. Est&aacute; faltando o acento, mas o que esse burro vai saber?",
            "Ganha aquele que n&atilde;o perde!"
             };

    /**
     * Random instance.
     */
    private static final Random RANDOM = new Random();

    /**
     * Retrieves a random sentence.
     * @return a random sentence
     */
    public String random() {
        return SENTENCES[RANDOM.nextInt(SENTENCES.length)];
    }
}
