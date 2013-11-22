class Request < ActiveRecord::Base

  belongs_to :school
  has_many :resources

end