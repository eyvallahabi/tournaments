package io.github.shiryu.tournaments.util;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@UtilityClass
public final class Colored {

	@NotNull
	public String convert(@NotNull final String text) { return ChatColor.translateAlternateColorCodes('&', text); }

	@NotNull
	public String convert(@NotNull final String text, @NotNull final Function<String, String> function){
		return function.apply(Colored.convert(text));
	}

	@NotNull
	public List<String> convert(@NotNull final List<String> list) { return list.stream().map(Colored::convert).collect(Collectors.toList());}

	@NotNull
	public List<String> convert(@NotNull final String... texts) { return convert(Arrays.asList(texts));}

	@NotNull
	public ListReplacer replaceAll(@NotNull final List<String> list) { return new ListReplacer(convert(list)); }

	@NotNull
	public String strip(@NotNull final String text) { return ChatColor.stripColor(text); }

	public class ListReplacer{

		private List<String> list;

		public ListReplacer(@NotNull final List<String> list){
			this.list = list;
		}

		@NotNull
		public ListReplacer replaceAll(@NotNull final String regex, @NotNull final String replacement){
			this.list = list.stream().map(l -> l.replaceAll(regex, replacement)).collect(Collectors.toList());

			return this;
		}

		@NotNull
		public ListReplacer replaceIf(@NotNull final String regex, @NotNull final String replacement, @NotNull final Predicate<String> predicate){
			if (predicate.test(regex))
				return this.replaceAll(regex, replacement);

			return this;
		}

		@NotNull
		public ListReplacer replaceFunctional(@NotNull final String regex, @NotNull final Function<String, String> function){
			this.list = list.stream().map(l -> l.replaceAll(regex, function.apply(l))).collect(Collectors.toList());

			return this;
		}

		@NotNull
		public List<String> build(){
			return this.list;
		}
	}

}
