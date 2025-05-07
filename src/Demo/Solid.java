package Demo;

// S - Single Responsibility Principle
class Invoice {
    private String item;
    private int quantity;

    public Invoice(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}

// O - Open/Closed Principle
abstract class InvoicePrinter {
    public abstract void print(Invoice invoice);
}

class PDFInvoicePrinter extends InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Printing invoice to PDF for: " + invoice.getItem());
    }
}

// L - Liskov Substitution Principle
class EmailInvoicePrinter extends InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Emailing invoice for: " + invoice.getItem());
    }
}

// I - Interface Segregation Principle
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class SimplePrinter implements Printer {
    public void print() {
        System.out.println("Printing document...");
    }
}

// D - Dependency Inversion Principle
class InvoiceService {
    private InvoicePrinter printer;

    public InvoiceService(InvoicePrinter printer) {
        this.printer = printer;
    }

    public void processInvoice(Invoice invoice) {
        printer.print(invoice);
    }
}

// Main class
public class Solid {
    public static void main(String[] args) {
        Invoice invoice = new Invoice("Book", 2);
        InvoicePrinter printer = new PDFInvoicePrinter();
        InvoiceService service = new InvoiceService(printer);
        service.processInvoice(invoice);
    }
}
