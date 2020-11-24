<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <xsl:value-of select="count(/autok/auto[ar>=30000])"/>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>