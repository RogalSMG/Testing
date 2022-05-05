import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class MakeJson {
    public static String XML_STRING = """
            <PurchaseOrder PurchaseOrderNumber="99503" OrderDate="1999-10-20">
                <Address Type="Shipping">
                    <Name>Ellen Adams</Name>
                    <Street>123 Maple Street</Street>
                    <City>Mill Valley</City>
                    <State>CA</State>
                    <Zip>10999</Zip>
                    <Country>USA</Country>
                </Address>
                <Address Type="Billing">
                    <Name>Tai Yee</Name>
                    <Street>8 Oak Avenue</Street>
                    <City>Old Town</City>
                    <State>PA</State>
                    <Zip>95819</Zip>
                    <Country>USA</Country>
                    </Address>
                <DeliveryNotes>Please leave packages in shed by driveway.</DeliveryNotes>
                <Items>
                    <Item PartNumber="872-AA">
                        <ProductName>Lawnmower</ProductName>
                        <Quantity>1</Quantity>
                        <USPrice>148.95</USPrice>
                        <Comment>Confirm this is electric</Comment>
                    </Item>
                    <Item PartNumber="926-AA">
                        <ProductName>Baby Monitor</ProductName>
                        <Quantity>2</Quantity>
                        <USPrice>39.98</USPrice>
                        <ShipDate>1999-05-21</ShipDate>
                    </Item>
                </Items>
            </PurchaseOrder>""";

    /*Output

    {"PurchaseOrder": {
    "PurchaseOrderNumber": 99503,
    "Address": [
        {
            "Zip": 10999,           // algorytm dodatkowo zmienia kolejność pól
            "Type": "Shipping",
            "State": "CA",
            "Street": "123 Maple Street",
            "Country": "USA",
            "City": "Mill Valley",
            "Name": "Ellen Adams"
        },
        {
            "Zip": 95819,
            "Type": "Billing",
            "State": "PA",
            "Street": "8 Oak Avenue",
            "Country": "USA",
            "City": "Old Town",
            "Name": "Tai Yee"
        }
    ],
    "Items": {"Item": [
        {
            "Comment": "Confirm this is electric",
            "PartNumber": "872-AA",
            "ProductName": "Lawnmower",
            "Quantity": 1,
            "USPrice": 148.95
        },
        {
            "PartNumber": "926-AA",
            "ProductName": "Baby Monitor",
            "Quantity": 2,
            "USPrice": 39.98,
            "ShipDate": "1999-05-21"
        }
    ]},
    "DeliveryNotes": "Please leave packages in shed by driveway.",
    "OrderDate": "1999-10-20"
}}
     */

    public static void main(String[] args) {
        int INDENT = 4;

        try {
            JSONObject xmlJSONObj = XML.toJSONObject(XML_STRING);
            String jsonPrettyPrintString = xmlJSONObj.toString(INDENT);
            System.out.println(jsonPrettyPrintString);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    }

    //Another xml which I was testing because of my curiosity
    public static String anotherXml = """
            <?xml version="1.0" encoding="UTF-8"?>
            <project version="4">
              <component name="ProjectModuleManager">
                <modules>
                  <module fileurl="file://$PROJECT_DIR$/Testing.iml" filepath="$PROJECT_DIR$/Testing.iml" />
                </modules>
              </component>
            </project>""";
    /*Output
{   "project": {
    "component": {
        "name": "ProjectModuleManager",
        "modules": {"module": {
            "filepath": "$PROJECT_DIR$/Testing.iml",
            "fileurl": "file://$PROJECT_DIR$/Testing.iml"
        }}
    },
    "version": 4
}}
     */

    public static String manifest = """
            <a cc = "1o">
                <c>10</c>
                <c>20</c>
            </a>
            """;
    /* Output
{   "a": {
    "cc": "1o",
    "c": [
        10,
        20
    ]
}}
     */

    public static String arrayInstead = """
            <a b = 10 />
            <b a = 20 />
            """;
    /*Output
{
    "a": {"b": 10},
    "b": {"a": 20}
}
     */

    public static String childNode = """
            <id session="3ddfa331fd1393029">
                <entryTime> 12.00 </entryTime>
            952</id>
            """;
    /* Output
{   "id": {
    "entryTime": "12.00",
    "session": "3ddfa331fd1393029",
    "content": 952
}}
     */
}
