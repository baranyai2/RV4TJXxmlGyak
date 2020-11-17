<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th style="text-align:left">Ora</th>
                        <th style="text-align:left">Hetfo</th>
                        <th style="text-align:left">Kedd</th>
                    </tr>
                    <tr>
                        <td>12-13</td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Hetfo'">
                                        <xsl:choose>
                                            <xsl:when test="idopont/tol = 12">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Kedd'">
                                        <xsl:choose>
                                            <xsl:when test="idopont/tol = 12">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr>
                        <td>13-14</td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Hetfo'">
                                        <xsl:choose>
                                            <xsl:when test="13 &gt; idopont/tol and 13 &lt; idopont/ig">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Kedd'">
                                        <xsl:choose>
                                            <xsl:when test="13 &gt; idopont/tol and 13 &lt; idopont/ig">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr>
                        <td>14-15</td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Hetfo'">
                                        <xsl:choose>
                                            <xsl:when test="14 &gt; idopont/tol and 14 &lt; idopont/ig">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Kedd'">
                                        <xsl:choose>
                                            <xsl:when test="14 &gt; idopont/tol and 14 &lt; idopont/ig">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr>
                        <td>15-16</td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Hetfo'">
                                        <xsl:choose>
                                            <xsl:when test="15 &gt; idopont/tol and 15 &lt; idopont/ig">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Kedd'">
                                        <xsl:choose>
                                            <xsl:when test="15 &gt; idopont/tol and 15 &lt; idopont/ig">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr>
                        <td>16-17</td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Hetfo'">
                                        <xsl:choose>
                                            <xsl:when test="16 &gt; idopont/tol and 16 &lt; idopont/ig">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Kedd'">
                                        <xsl:choose>
                                            <xsl:when test="16 &gt; idopont/tol and 16 &lt; idopont/ig">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr>
                        <td>17-18</td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Hetfo'">
                                        <xsl:choose>
                                            <xsl:when test="17 &gt; idopont/tol and 17 &lt; idopont/ig">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                        <td>
                            <xsl:for-each select="orarend/ora">
                                <xsl:choose>
                                    <xsl:when test="idopont/nap = 'Kedd'">
                                        <xsl:choose>
                                            <xsl:when test="17 &gt; idopont/tol and 17 &lt; idopont/ig">
                                                <xsl:value-of select="targy"/><br/>
                                                <xsl:value-of select="oktato"/><br/>
                                                <xsl:value-of select="helyszin"/>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>