const articles = [
	{title: "How to maximize your time at the gym", 
	story: "This is perhaps the most basic tip we can give you, but it’s also one of the most important if you want to make every minute count when you’re hitting the weights. It’s also a no-brainer, as walking into the gym with a good plan of action will help minimize the chances of you wandering aimlessly around and thinking what to do next, or even how to start in the first place. Do I do cardio today? Or do I focus on my core workouts? Such indecisiveness will only lead to wasted time and let your heart rate drop."},
	{title: "Why picking up your medication on time matters", 
	story: "Oftentimes, doctors prescribe medications that need to be taken at specific times throughout the day. This may lead you to ask if taking your medications at specific times is important, and the answer is yes. Why? Taking medicine on time, as prescribed, is essential to making sure your body has an effective amount of the drug at all times. If not, this can cause the disease to develop a resistance to the medicine or simply prolong the amount of time it takes to feel better. The Centers for Disease Control and Prevention estimates that not taking medicine on time accounts for up to 50 percent of disease treatment failure. If you are unsure of when you should be taking a medication, ask your doctor."},
	{title: "Ibuprofen, what does it do?", 
	story: "Ibuprofen is used to relieve pain from various conditions such as headache, dental pain, menstrual cramps, muscle aches, or arthritis. It is also used to reduce fever and to relieve minor aches and pain due to the common cold or flu. Ibuprofen is a nonsteroidal anti-inflammatory drug (NSAID). It works by blocking your body's production of certain natural substances that cause inflammation. This effect helps to decrease swelling, pain, or fever.If you are treating a chronic condition such as arthritis, ask your doctor about non-drug treatments and/or using other medications to treat your pain. See also Warning section.Check the ingredients on the label even if you have used the product before. The manufacturer may have changed the ingredients. Also, products with similar names may contain different ingredients meant for different purposes. Taking the wrong product could harm you."}
	]
	
let articleNumber = Math.floor(Math.random() * 3)
console.log(articleNumber)

let articleTitle = document.querySelector(".articleTitle")
let articleBody = document.querySelector(".articleBody")
articleTitle.innerHTML = articles[articleNumber].title
articleBody.innerHTML = articles[articleNumber].story
