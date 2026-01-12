import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalDemo {
	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static void print(Object obj1, Object obj2) {
		System.out.println(obj1 + ", " + obj2);
	}
	
	public static void main(String[] args) {

		Consumer<String> c1 = (s) -> System.out.println(s);
		c1.accept("Hello");

		Consumer<String> c2 = System.out::println;
		c2.accept("Bonjour");

		Consumer<String> c3 = FunctionalDemo::print;
		c3.accept("Aloha");

		BiConsumer<Integer, Integer> c4 = FunctionalDemo::print;
		c4.accept(100, 200);

		Supplier<String> s1 = () -> "Adios";
		System.out.println(s1.get());

		Supplier<Integer> s2 = () -> (int) (Math.random() * 100);
		System.out.println(s2.get());

		Predicate<Integer> positive = (x) -> x >= 0;
		System.out.println(positive.test(-5));
		System.out.println(positive.test(9));

		Predicate<Integer> even = (x) -> x % 2 == 0;
		System.out.println(even.test(3));
		System.out.println(even.test(4));

		BiPredicate<String, String> contains = (s, c) -> s.contains(c);
		System.out.println(contains.test("Hello", "a"));
		System.out.println(contains.test("Hello", "l"));

		Function<Integer, Integer> square = (x) -> x * x;
		System.out.println(square.apply(5));

		BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
		System.out.println(sum.apply(10, 20));
	}
}