using System.Text.Json;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddCors(options =>
{
    options.AddPolicy("no-cors-policy", policy =>{
        policy.AllowAnyHeader().AllowAnyMethod().AllowAnyOrigin();
    });
});
var app = builder.Build();
app.UseCors();

string adjectiveFileName = "Adjectives.json";
string adjectiveJsonString = File.ReadAllText(adjectiveFileName);
List<string> adjectives = JsonSerializer.Deserialize<List<string>>(adjectiveJsonString)!;

string peopleFileName = "People.json";
string peopleJsonString = File.ReadAllText(peopleFileName);
List<string> people = JsonSerializer.Deserialize<List<string>>(peopleJsonString)!;

app.MapGet("/", () => "Hello World!");

app.MapGet("/code", () =>
{
    Random rnd = new Random();
    var lWord = adjectives.ElementAt(rnd.Next(0, adjectives.Count));
    var rWord = people.ElementAt(rnd.Next(0, people.Count));
    Console.WriteLine($"{lWord}-{rWord}");
    return $"{lWord}-{rWord}";
}).RequireCors("no-cors-policy");

app.Run();
